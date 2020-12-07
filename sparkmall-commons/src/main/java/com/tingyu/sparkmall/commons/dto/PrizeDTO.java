package com.tingyu.sparkmall.commons.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author essionshy
 * @Create 2020/11/29 22:44
 * @Version renren-fast
 */
@Data
public class PrizeDTO {

    private Integer page;

    private Integer limit;
    private Integer prizeId;

    private Integer prizeLevel;

    private String prizeName;

    private BigDecimal price;

    private Integer status;
    /**
     * 奖品数量
     */
    private Integer amount;

    private String startTime;//开始时间

    private String endTime;//结束时间

    private String createTime; //创建时间

}
