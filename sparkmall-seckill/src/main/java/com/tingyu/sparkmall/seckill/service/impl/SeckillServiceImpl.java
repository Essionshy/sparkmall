package com.tingyu.sparkmall.seckill.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.tingyu.sparkmall.commons.dto.product.SkuInfoDTO;
import com.tingyu.sparkmall.commons.dto.seckill.SeckillSessionDTO;
import com.tingyu.sparkmall.commons.support.CommonResult;
import com.tingyu.sparkmall.seckill.feign.CouponFeignService;
import com.tingyu.sparkmall.seckill.feign.ProductFeignService;
import com.tingyu.sparkmall.seckill.service.SeckillService;
import com.tingyu.sparkmall.seckill.utils.SeckillConstant;
import com.tingyu.sparkmall.seckill.vo.SeckillSkuRedisVo;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RSemaphore;
import org.redisson.api.RedissonClient;
import org.springframework.beans.BeanUtils;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;
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


    /**
     * 缓存商品信息， hash 结构
     * @param data
     */
    private void saveSessionSkuInfos(List<SeckillSessionDTO> data) {
        BoundHashOperations<String, String, String> hashOps = stringRedisTemplate.boundHashOps(SeckillConstant.SECKILL_SKU_KEY_PREFIX);

        data.stream().forEach(session -> {
            session.getSeckillItems().stream().forEach(seckillSkuDTO -> {
                SeckillSkuRedisVo redisVo = new SeckillSkuRedisVo();

                //保存sku基本信息
                CommonResult<SkuInfoDTO> result = productFeignService.getSkuInfoById(seckillSkuDTO.getSkuId());

                if(result.getCode()==0){
                    SkuInfoDTO skuInfoDTO = result.getData();
                    redisVo.setSkuInfoDTO(skuInfoDTO);
                }
                //保存活动sku信息
                BeanUtils.copyProperties(seckillSkuDTO,redisVo);
                //保存商品秒杀的时间信息
                redisVo.setStartTime(session.getStartTime().getTime());
                redisVo.setEndTime(session.getEndTime().getTime());

                //保存商品秒杀访问令牌
                String accessToken = UUID.randomUUID().toString().replace("_", "");
                redisVo.setAccessToken(accessToken);

                //保存商品库存信息，使用信号量，并且需要带上访问令牌
                RSemaphore semaphore = redissonClient.getSemaphore(SeckillConstant.SECKILL_SKU_STOCK_SEMAPHORE + accessToken);
                semaphore.trySetPermits(seckillSkuDTO.getSeckillCount().intValue());

                String jsonString = JSONObject.toJSONString(redisVo);
                //封装保存到Redis中Sku的详细信息
                hashOps.put(seckillSkuDTO.getId().toString(),jsonString);
            });
        });



    }

    /**
     * 缓存活动信息
     * @param data
     */
    private void saveSessionInfos(List<SeckillSessionDTO> data) {
        data.stream().forEach(session -> {
            long startTime = session.getStartTime().getTime();
            long endTime = session.getEndTime().getTime();
            String key = SeckillConstant.SECKILL_SESSION_KEY_PREFIX + startTime + "_" + endTime;
            List<String> collect = session.getSeckillItems().stream().map(item ->
                 item.getId().toString()+"_"+item.getSkuId()
            ).collect(Collectors.toList());

            stringRedisTemplate.opsForList().leftPushAll(key,collect);
        });

    }


}
