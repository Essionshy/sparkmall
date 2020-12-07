package com.tingyu.sparkmall.lottery.strategy;


import com.tingyu.sparkmall.lottery.entity.RecordEntity;

import java.util.List;

/**
 * @Author essionshy
 * @Create 2020/5/8 13:37
 * @Version sparkmall
 */
public interface LotteryStrategy {


    /**
     * @param level 奖项等级
     * @param count 奖品数量
     * @return 返回中奖号码， 可以是用户手机号，也只可以是随机生成的号码，
     */
    List<RecordEntity> lottery(int level, long count);

}
