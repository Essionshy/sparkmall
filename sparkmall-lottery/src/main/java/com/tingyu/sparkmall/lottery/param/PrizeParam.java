package com.tingyu.sparkmall.lottery.param;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * @Author essionshy
 * @Create 2020/5/8 11:42
 * @Version sparkmall
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Accessors(chain = true)
public class PrizeParam {

    private Integer page;

    private Integer limit;

    private Integer prizeId;

    private String prizeLevel;

    private String prizeName;

    private BigDecimal price;

    private Integer status;

    private String startTime;//开始时间

    private String endTime;//结束时间

    private String gmtCreate; //创建时间
}
