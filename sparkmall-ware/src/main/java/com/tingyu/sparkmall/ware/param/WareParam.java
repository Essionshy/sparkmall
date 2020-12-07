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

    /*分页参数*/
    private Integer page;

    private Long limit;

    /**
     * 封装属性
     */

    private Long id;

    private String name;

    private String productNo;

    private BigDecimal count;

    /*查询条件*/

    private String key;
}
