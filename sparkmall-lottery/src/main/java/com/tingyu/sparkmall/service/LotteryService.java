package com.tingyu.sparkmall.service;

import com.tingyu.sparkmall.param.LotteryParam;

/**
 * @Author essionshy
 * @Create 2020/5/8 12:21
 * @Version sparkmall
 */
public interface LotteryService {
    Integer lottery(LotteryParam param); //返回奖品编号

    boolean isExists(LotteryParam param);

    boolean isOver(Integer prizeId);

    /**
     * 发送中奖记录到 RabbitMQ
     *
     * @param param
     * @return 返回中奖记录用户ID
     */
    Integer sendRecordMessage(LotteryParam param);


}
