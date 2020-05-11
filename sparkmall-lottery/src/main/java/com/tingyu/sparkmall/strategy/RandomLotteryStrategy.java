package com.tingyu.sparkmall.strategy;

import com.tingyu.sparkmall.entity.RecordEntity;

/**
 * @Author essionshy
 * @Create 2020/5/8 13:42
 * @Version sparkmall
 */
public class RandomLotteryStrategy implements LotteryStrategy {

    @Override
    public RecordEntity lotteryDistribution(RecordEntity record) {
        //每次请求会生成一个随机码，如果随机码落在抽奖范围内，则中奖，否则不中

        return null;
    }
}
