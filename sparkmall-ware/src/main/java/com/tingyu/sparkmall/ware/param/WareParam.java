package com.tingyu.sparkmall.ware.param;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author essionshy
 * @Create 2020/11/28 0:23
 * @Version renren-fast
 */
@Data
public class WareParam {

    private Long id;

    private String name;

    private String productNo;

    private BigDecimal count;
}
