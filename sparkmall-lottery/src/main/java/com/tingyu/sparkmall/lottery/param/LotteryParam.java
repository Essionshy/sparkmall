package com.tingyu.sparkmall.lottery.param;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @Author essionshy
 * @Create 2020/5/8 12:22
 * @Version sparkmall
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Accessors(chain = true)
public class LotteryParam {

    private Long userId;//用户编号

    private Integer prizeId;

    private String lotteryTime; //抽奖时间

    private Integer type; //抽奖方式 0 随机

    private Long count; //抽奖数量

}
