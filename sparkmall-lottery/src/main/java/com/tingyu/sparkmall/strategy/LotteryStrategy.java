package com.tingyu.sparkmall.strategy;

import com.tingyu.sparkmall.entity.RecordEntity;

/**
 * @Author essionshy
 * @Create 2020/5/8 13:37
 * @Version sparkmall
 */
public interface LotteryStrategy {

    RecordEntity lotteryDistribution(RecordEntity record);

}
