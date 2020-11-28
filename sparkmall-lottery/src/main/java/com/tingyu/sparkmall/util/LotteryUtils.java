package com.tingyu.sparkmall.util;

import com.tingyu.sparkmall.entity.lottery.RecordEntity;
import com.tingyu.sparkmall.param.LotteryParam;
import com.tingyu.sparkmall.strategy.FixLotteryStrategy;
import com.tingyu.sparkmall.strategy.LotteryStrategy;
import com.tingyu.sparkmall.strategy.RandomLotteryStrategy;

import java.util.List;

/**
 * @Author essionshy
 * @Create 2020/5/8 14:03
 * @Version sparkmall
 */
public final class LotteryUtils {

    private static LotteryStrategy DEFAULT_STRATEGY = new FixLotteryStrategy();

    private LotteryUtils() {
    }


    /**
     * 随机抽奖
     *
     * @param param
     * @return
     */
    public static List<RecordEntity> random(LotteryParam param) {
        LotteryStrategy randomLotteryStrategy = new RandomLotteryStrategy();
        List<RecordEntity> lottery = randomLotteryStrategy.lottery(param.getPrizeId(), param.getCount());
        return lottery;
    }


}
