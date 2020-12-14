package com.tingyu.sparkmall.seckill.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.tingyu.sparkmall.commons.dto.MemberDTO;
import com.tingyu.sparkmall.commons.dto.product.SkuInfoDTO;
import com.tingyu.sparkmall.commons.dto.seckill.SeckillSessionDTO;
import com.tingyu.sparkmall.commons.dto.seckill.SeckillSkuDTO;
import com.tingyu.sparkmall.commons.exception.ResultException;
import com.tingyu.sparkmall.commons.support.CommonResult;
import com.tingyu.sparkmall.commons.utils.OrderNoGeneratorUtil;
import com.tingyu.sparkmall.seckill.feign.CouponFeignService;
import com.tingyu.sparkmall.seckill.feign.ProductFeignService;
import com.tingyu.sparkmall.seckill.interceptor.SeckillLoginInterceptor;
import com.tingyu.sparkmall.seckill.service.SeckillService;
import com.tingyu.sparkmall.seckill.utils.SeckillConstant;
import com.tingyu.sparkmall.seckill.vo.SeckillSkuRedisVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.redisson.api.RSemaphore;
import org.redisson.api.RedissonClient;
import org.springframework.beans.BeanUtils;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @Author essionshy
 * @Create 2020/12/11 14:56
 * @Version renren-fast
 */
@Service
@Slf4j
public class SeckillServiceImpl implements SeckillService {


    @Resource
    private CouponFeignService couponFeignService;

    @Resource
    private ProductFeignService productFeignService;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private RedissonClient redissonClient;

    @Override
    public void up() {

        //查询最近三天秒杀活动
        CommonResult<List<SeckillSessionDTO>> result = couponFeignService.listLatest3DaysSessions();

        if (result.getCode() == 0) {
            List<SeckillSessionDTO> data = result.getData();

            if (data != null && data.size() > 0) {
                //缓存活动场次信息 保存字符串
                saveSessionInfos(data);
                //缓存商品列表信息，保存成一个list
                saveSessionSkuInfos(data);


            }


        }
        //

    }

    @Override
    public List<SeckillSkuRedisVo> listCurrentSeckillSessionSkus() {
        List<SeckillSkuRedisVo> seckillSkuRedisVos = new ArrayList<>();
        BoundHashOperations<String, String, Object> hashOps = stringRedisTemplate.boundHashOps(SeckillConstant.SECKILL_SKU_KEY);

        Set<String> keys = stringRedisTemplate.keys(SeckillConstant.SECKILL_SESSION_KEY_PREFIX + "*");

        //构建所有秒杀活动场次ID_商品ID的keys集合
        List<String> sessionIdAndSkuIds = new ArrayList<>();

        //获取当前时间参与秒杀的商品信息

        long currentTime = new Date().getTime();
        for (String key : keys) {
            String replace = key.replace(SeckillConstant.SECKILL_SESSION_KEY_PREFIX, "");
            String[] session = replace.split("_");
            long startTime = Long.parseLong(session[0]);
            long endTime = Long.parseLong(session[1]);
            if (currentTime >= startTime && currentTime <= endTime) {
                List<String> range = stringRedisTemplate.opsForList().range(key, -100, 100);
                sessionIdAndSkuIds.addAll(range);
            }

        }

        if (sessionIdAndSkuIds.size() > 0) {
            //从Redis中取出所有商品信息
            List<Object> list = hashOps.multiGet(sessionIdAndSkuIds);


            //反序列化
            for (Object obj : list) {
                String json = (String) obj;

                SeckillSkuRedisVo seckillSkuRedisVo = JSONObject.parseObject(json, SeckillSkuRedisVo.class);
                seckillSkuRedisVos.add(seckillSkuRedisVo);
            }

        }


        return seckillSkuRedisVos;
    }

    @Override
    public String seckill(String killId, String accessToken, Integer num) throws Exception {
        MemberDTO member = SeckillLoginInterceptor.threadLocal.get();
        BoundHashOperations<String, Object, Object> hashOps = stringRedisTemplate.boundHashOps(SeckillConstant.SECKILL_SKU_KEY);
        String json = (String) hashOps.get(killId);

        if (StringUtils.isEmpty(json)) {
            throw new ResultException(200, "活动已结束");
        }
        SeckillSkuRedisVo redisVo = JSONObject.parseObject(json, SeckillSkuRedisVo.class);

        //验证时间合法性
        Long startTime = redisVo.getStartTime();
        Long endTime = redisVo.getEndTime();
        long currentTime = new Date().getTime();
        if (currentTime < startTime || currentTime > endTime) {
            throw new ResultException(200, "活动没有找到");
        }

        //验证访问令牌与秒杀活动是否合法
        String token = redisVo.getAccessToken();
        if (!token.equalsIgnoreCase(accessToken)) {
            throw new ResultException(200, "非法访问");
        }
        //验证用户秒杀商品数量是否合法
        int limit = redisVo.getSeckillLimit().intValue();
        if (num > limit) {
            throw new ResultException(200, "对不起你所选商品数量超过本次最大购买数量" + limit);
        }
        //验证当前用户是否已经秒杀过      通过设置占位的方式来判断 seckill:user:  sessionId_skuId_userId;

        String key = member.getPhone() + "_" + redisVo.getPromotionSessionId() + "_" + redisVo.getSkuId();
        long expire = (endTime - currentTime);
        Boolean ifAbsent = stringRedisTemplate.opsForValue().setIfAbsent(key, "", expire, TimeUnit.MILLISECONDS);

        if (!ifAbsent) {
            throw new ResultException(200, "你已经秒杀成功，不能重复秒杀");
        }


        //开始秒杀

        RSemaphore semaphore = redissonClient.getSemaphore(SeckillConstant.SECKILL_SKU_STOCK_SEMAPHORE_PREFIX + accessToken);

        boolean tryAcquire = semaphore.tryAcquire(num);

        if (tryAcquire) {
            //生成订单号
            String orderNo = OrderNoGeneratorUtil.getOrderNo();

            // TODO 发送订单信息到消息队列，则MQ 订单服务监听，创建秒杀定单
            return orderNo;

        }


        return null;
    }


    /**
     * 缓存商品信息， hash 结构
     *
     * @param data
     */
    private void saveSessionSkuInfos(List<SeckillSessionDTO> data) {
        BoundHashOperations<String, String, String> hashOps = stringRedisTemplate.boundHashOps(SeckillConstant.SECKILL_SKU_KEY);


            data.stream().forEach(session -> {

                List<SeckillSkuDTO> seckillItems = session.getSeckillItems();

                if(seckillItems!=null && seckillItems.size()>0){
                    seckillItems.stream().forEach(seckillSkuDTO -> {

                        String key = seckillSkuDTO.getPromotionSessionId() + "_" + seckillSkuDTO.getSkuId();
                        if (!hashOps.hasKey(key)) {
                            SeckillSkuRedisVo redisVo = new SeckillSkuRedisVo();

                            //保存sku基本信息
                            CommonResult<SkuInfoDTO> result = productFeignService.getSkuInfoById(seckillSkuDTO.getSkuId());

                            if (result.getCode() == 0) {
                                SkuInfoDTO skuInfoDTO = result.getData();
                                redisVo.setSkuInfoDTO(skuInfoDTO);
                            }
                            //保存活动sku信息
                            BeanUtils.copyProperties(seckillSkuDTO, redisVo);
                            //保存商品秒杀的时间信息
                            redisVo.setStartTime(session.getStartTime().getTime());
                            redisVo.setEndTime(session.getEndTime().getTime());

                            //保存商品秒杀访问令牌
                            String accessToken = UUID.randomUUID().toString().replace("-", "");
                            redisVo.setAccessToken(accessToken);

                            //保存商品库存信息，使用信号量，并且需要带上访问令牌
                            RSemaphore semaphore = redissonClient.getSemaphore(SeckillConstant.SECKILL_SKU_STOCK_SEMAPHORE_PREFIX + accessToken);
                            semaphore.trySetPermits(seckillSkuDTO.getSeckillCount().intValue());

                            String jsonString = JSONObject.toJSONString(redisVo);
                            //封装保存到Redis中Sku的详细信息
                            hashOps.put(key, jsonString);
                        }


                    });
                }


            });



    }

    /**
     * 缓存活动信息
     *
     * @param data
     */
    private void saveSessionInfos(List<SeckillSessionDTO> data) {
        data.stream().forEach(session -> {
            //判断活动中商品信息是否为空

            long startTime = session.getStartTime().getTime();
            long endTime = session.getEndTime().getTime();
            String key = SeckillConstant.SECKILL_SESSION_KEY_PREFIX + startTime + "_" + endTime;

            //如果活动不存在则添加
            if (!stringRedisTemplate.hasKey(key)) {
                List<SeckillSkuDTO> seckillItems = session.getSeckillItems();

                if (seckillItems != null && seckillItems.size() > 0) {
                    List<String> collect = seckillItems.stream().map(item ->

                            item.getPromotionSessionId().toString() + "_" + item.getSkuId()
                    ).collect(Collectors.toList());
                    stringRedisTemplate.opsForList().leftPushAll(key, collect);
                }
            }


        });

    }


}
