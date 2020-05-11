package com.tingyu.sparkmall.scheduler;

import com.tingyu.sparkmall.entity.PrizeEntity;
import com.tingyu.sparkmall.service.PrizeService;
import com.tingyu.sparkmall.support.LotteryStatusEnum;
import com.tingyu.sparkmall.util.RedisKeys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author essionshy
 * @Create 2020/5/8 18:47
 * @Version sparkmall
 */
@Slf4j
@Component
public class LotteryTask {

    @Resource
    PrizeService prizeService;

    @Resource
    RedisTemplate<String, Object> redisTemplate;

    //每5秒钟执行一次
    @Scheduled(cron = "0/5 * * * * ?")
    public void process() {

        List<PrizeEntity> allUnStartedPrize = prizeService.findAllUnStartedPrize();
        allUnStartedPrize.forEach(prize -> {
            log.info("[{}]抽奖活动已经开始...", prize.getPrizeLevel());
            for (int i = 0; i < prize.getAmount(); i++) {
                redisTemplate.opsForList().rightPush(RedisKeys.PRIZE_KEY_PREFIX + prize.getPrizeId(), prize.getPrizeId());
            }
            prize.setStatus(LotteryStatusEnum.RUNNING.getCode());
            prizeService.updateStatus(LotteryStatusEnum.RUNNING.getCode(), prize.getPrizeId());
            //数据准备，将活动相关数据存放进Redis缓存中
        });
    }
}
