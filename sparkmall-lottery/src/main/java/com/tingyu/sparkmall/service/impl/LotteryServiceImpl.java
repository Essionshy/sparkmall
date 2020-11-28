package com.tingyu.sparkmall.service.impl;

import com.tingyu.sparkmall.entity.lottery.RecordEntity;
import com.tingyu.sparkmall.event.RecordEvent;
import com.tingyu.sparkmall.exception.ResultException;
import com.tingyu.sparkmall.param.LotteryParam;
import com.tingyu.sparkmall.service.LotteryService;
import com.tingyu.sparkmall.service.PrizeService;
import com.tingyu.sparkmall.strategy.LotteryStrategy;
import com.tingyu.sparkmall.support.enums.BizCodeEnum;
import com.tingyu.sparkmall.support.enums.LotteryStatusEnum;
import com.tingyu.sparkmall.utils.RedisKeys;
import com.tingyu.sparkmall.vo.MemberVo;
import com.tingyu.sparkmall.vo.RecordVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
    StringRedisTemplate stringRedisTemplate;

    @Resource
    ListOperations<String, Object> listOperations;

    @Resource
    SetOperations<String, Object> setOperations;

    @Resource
    RabbitTemplate rabbitTemplate;

    @Resource
    ApplicationEventPublisher eventPublisher;

    @Autowired
    LotteryStrategy randomLotteryStrategy;


    @Autowired
    private PrizeService prizeService;

    @Override
    public Integer lottery(LotteryParam param) {
        //验证当前用户是否已经中奖
        if (isExists(param)) {
            throw new ResultException(BizCodeEnum.LOTTERY_EXISTS.getCode(), BizCodeEnum.LOTTERY_EXISTS.getMessage());
        }
        //验证奖品是否已经抽取完成
        if (isOver(param.getPrizeId())) {
            //当奖品抽取完成时，修改抽奖状态
            prizeService.updateStatus(LotteryStatusEnum.OVER.getCode(), param.getPrizeId());
            throw new ResultException(BizCodeEnum.LOTTERY_OVER.getCode(), BizCodeEnum.LOTTERY_OVER.getMessage());
        }
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

    @Override
    public boolean register(MemberVo memberVo) {

        //判断活动是否存在,Redis中一个不存在的set其size为0 ；如果 set中没有元素，则redis会删除该key;

        Long size = setOperations.size(RedisKeys.RANDOM_LOTTERY_KEY);

        if (size == 0) {
            throw new ResultException(BizCodeEnum.LOTTERY_OVER.getCode(), BizCodeEnum.LOTTERY_OVER.getMessage());
        }
        //判断用户是否已经报名
        String phone = memberVo.getPhone();
        Boolean isMember = setOperations.isMember(RedisKeys.RANDOM_LOTTERY_KEY, phone);
        if (isMember) {
            throw new ResultException(BizCodeEnum.LOTTERY_REGISTERED.getCode(), BizCodeEnum.LOTTERY_REGISTERED.getMessage());
        }

        try {
            //将用户添加到抽奖池
            setOperations.add(RedisKeys.RANDOM_LOTTERY_KEY, phone);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }


    }

    @Override
    public List<RecordVO> randomLottery(LotteryParam param) {

        List<RecordEntity> lottery = randomLotteryStrategy.lottery(param.getPrizeId(), param.getCount());

        if (lottery == null && lottery.size() == 0) {
            return null;
        }

        List<RecordVO> recordVOList = lottery.stream().map(recordEntity -> {
            RecordVO recordVO = new RecordVO();
            BeanUtils.copyProperties(recordEntity, recordVO);
            return recordVO;
        }).collect(Collectors.toList());

        return recordVOList;
    }


}
