package com.tingyu.sparkmall.strategy;


import com.tingyu.sparkmall.entity.lottery.RecordEntity;
import com.tingyu.sparkmall.utils.RedisKeys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 随机抽奖，抽奖活动开始前需要用户参与抽奖活动[将其保存到Redis的set中]，抽奖时，随机抽取 n 名用户，
 * <p>
 * 中奖的用户将不再拥有抽奖资格
 *
 * 适合于系统内开奖，不适用于多个客户端抢资源的场景
 *
 * @Author essionshy
 * @Create 2020/5/8 13:42
 * @Version sparkmall
 */
@Service
public class RandomLotteryStrategy implements LotteryStrategy {


    @Autowired
    private SetOperations<String,Object> setOperations;



    @Override
    public List<RecordEntity> lottery(int prizeId, long count) {

        //判断

        List<Object> phoneList = setOperations.pop(RedisKeys.RANDOM_LOTTERY_KEY, count); //中奖用户手机号列表

        if (phoneList == null || phoneList.size() == 0) {
            return null;
        }

        //保存中奖记录
        List<RecordEntity> records = new ArrayList<>();
        Iterator<Object> iterator = phoneList.iterator();
        while (iterator.hasNext()) {
            String next = (String) iterator.next();
            //封装中奖记录
            RecordEntity record = new RecordEntity();
            record.setPhone(next);
            record.setPrizeId(prizeId);
            records.add(record);
        }
        return records;
    }
}
