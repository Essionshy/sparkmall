package com.tingyu.sparkmall.service.impl;

import com.tingyu.sparkmall.event.RecordEvent;
import com.tingyu.sparkmall.param.LotteryParam;
import com.tingyu.sparkmall.service.LotteryService;
import com.tingyu.sparkmall.util.RedisKeys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author essionshy
 * @Create 2020/5/8 12:36
 * @Version sparkmall
 */
@Slf4j
@Service
public class LotteryServiceImpl implements LotteryService {

    @Resource
    RedisTemplate<String, Object> redisTemplate;

    @Resource
    ListOperations<String, Object> listOperations;

    @Resource
    RabbitTemplate rabbitTemplate;

    @Resource
    ApplicationEventPublisher eventPublisher;

    @Override
    public Integer lottery(LotteryParam param) {
        //抽奖规则
        Integer prizeId = (Integer) listOperations.leftPop(RedisKeys.PRIZE_KEY_PREFIX + param.getPrizeId());
        redisTemplate.opsForSet().add(RedisKeys.LOTTERY_USER_KEY_PREFIX + param.getPrizeId(), param.getUserId());
        eventPublisher.publishEvent(new RecordEvent(param));
        return prizeId;
    }

    @Override
    public boolean isExists(LotteryParam param) {
        return redisTemplate.opsForSet().isMember(RedisKeys.LOTTERY_USER_KEY_PREFIX + param.getPrizeId(), param.getUserId());
    }

    @Override
    public boolean isOver(Integer prizeId) {

        if (redisTemplate.opsForList().leftPop(RedisKeys.PRIZE_KEY_PREFIX + prizeId) == null) {
            return true;
        } else {
            //每次判断都会消耗一次，因此如果不为null时，应该将数量补回
            redisTemplate.opsForList().rightPush(RedisKeys.PRIZE_KEY_PREFIX + prizeId, prizeId);
            return false;
        }
    }

    @Override
    public Integer sendRecordMessage(LotteryParam param) {
        Map<String, Object> data = new HashMap<>();
        data.put("userId", param.getUserId());
        data.put("prizeId", param.getPrizeId());
        rabbitTemplate.convertAndSend("exchange-lottery", null, data);
        return null;
    }


}
