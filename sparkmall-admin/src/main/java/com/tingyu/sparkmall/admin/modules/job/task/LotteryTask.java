package com.tingyu.sparkmall.admin.modules.job.task;


import com.google.gson.Gson;
import com.tingyu.sparkmall.admin.modules.job.feign.PrizeFeignService;
import com.tingyu.sparkmall.entity.lottery.PrizeEntity;
import com.tingyu.sparkmall.param.PrizeParam;
import com.tingyu.sparkmall.support.enums.LotteryStatusEnum;
import com.tingyu.sparkmall.utils.R;
import com.tingyu.sparkmall.utils.RedisKeys;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author essionshy
 * @Create 2020/5/8 18:47
 * @Version sparkmall
 */
@Slf4j
@Component
public class LotteryTask implements ITask {



    @Resource
    RedisTemplate<String, Object> redisTemplate;

    @Resource
    RedissonClient redisson;

    @Resource
    PrizeFeignService prizeFeignService;

    @Override
    public void run(String params) {
        RLock lock= redisson.getLock(RedisKeys.LOTTER_LOCK_KEY);
        lock.lock();
        try{

            R result = prizeFeignService.findAllUnStartedPrize();

            List<Map<String,Object>>  maps = (List<Map<String, Object>>) result.get("list");

            for (Map<String,Object > map:maps){
                Integer prizeId= (Integer) map.get("prizeId");
                String prizeLevel= (String) map.get("prizeLevel");
                int amount=(int)map.get("amount");
                if(log.isDebugEnabled()){
                    log.debug("[{}]抽奖活动已经开始...", prizeLevel);
                }
                for (int i = 0; i < amount; i++) {
                    redisTemplate.opsForList().rightPush(RedisKeys.PRIZE_KEY_PREFIX+ prizeId.toString(), prizeId.toString());
                }
                if(log.isDebugEnabled()){
                    log.debug("数据迁移至Redis完成，即将执行更新抽奖状态...");
                }
                /* update lottery status*/
                updateLotteryStatus(prizeId);
                if(log.isDebugEnabled()){
                    log.debug("更新抽奖状态完成...");
                }
                /* pause task*/

            }
        }catch (Exception e){
                e.printStackTrace();
        }finally {
            lock.unlock();
        }


    }

    /**
     * 解析参数并封装成Map对象
     * @param params
     * @return
     */
    private Map<String,Object> resolveParam(String params){
        Map<String,Object> queryParams=null;
        if(!StringUtils.isEmpty(params)){
            queryParams=new HashMap<>();
            Gson gson = new Gson();
            PrizeParam prizeParam = gson.fromJson(params, PrizeParam.class);
            queryParams.put("prizeId",prizeParam.getPrizeId());
            queryParams.put("page",prizeParam.getPage());
            queryParams.put("limit",prizeParam.getLimit());
            queryParams.put("status",prizeParam.getStatus());
        }
       return queryParams;
    }

    //更新抽奖状态
    public void updateLotteryStatus(Integer prizeId){
        //修改抽奖状态为正在进行中...【0：未开始；1：正在进行中；2：已结束】

        PrizeEntity prizeEntity = new PrizeEntity();
        prizeEntity.setPrizeId(prizeId);
        prizeEntity.setStatus(LotteryStatusEnum.RUNNING.getCode());
        Gson gson = new Gson();

        prizeFeignService.update(prizeEntity);
    }

}
