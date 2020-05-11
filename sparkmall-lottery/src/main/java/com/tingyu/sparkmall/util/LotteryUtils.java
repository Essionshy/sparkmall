package com.tingyu.sparkmall.util;

import com.tingyu.sparkmall.entity.RecordEntity;
import com.tingyu.sparkmall.strategy.FixLotteryStrategy;
import com.tingyu.sparkmall.strategy.LotteryStrategy;

/**
 * @Author essionshy
 * @Create 2020/5/8 14:03
 * @Version sparkmall
 */
public class LotteryUtils {

    private static LotteryStrategy DEFAULT_STRATEGY = new FixLotteryStrategy();

    private LotteryUtils() {
    }

    /**
     * 根据指定抽奖策略来进行抽奖
     *
     * @param record   中奖记录
     * @param strategy 抽奖策略
     * @return
     */
    public static RecordEntity lotteryDistributed(RecordEntity record, LotteryStrategy strategy) {
        return strategy.lotteryDistribution(record);
    }

    /**
     * 默认按照固定抽奖策略来进行抽奖
     *
     * @param record
     * @return
     */
    public static RecordEntity lotteryDistributed(RecordEntity record) {
        return lotteryDistributed(record, DEFAULT_STRATEGY);
    }

}
