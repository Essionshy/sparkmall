package com.tingyu.sparkmall.lottery.service;


import com.tingyu.sparkmall.commons.dto.MemberDTO;
import com.tingyu.sparkmall.lottery.param.LotteryParam;
import com.tingyu.sparkmall.lottery.vo.RecordVO;

import java.util.List;

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

    boolean register(MemberDTO member); //报名：活动已结束，如果用户已经注册，不允许重复报名


    List<RecordVO> randomLottery(LotteryParam param);
}
