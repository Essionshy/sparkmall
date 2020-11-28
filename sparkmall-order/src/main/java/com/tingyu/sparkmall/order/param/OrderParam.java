package com.tingyu.sparkmall.order.param;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 订单参数，接收前端传递过来的订单参数
 * @Author essionshy
 * @Create 2020/11/27 22:24
 * @Version renren-fast
 */
@Data
public class OrderParam {

    private String orderNo; //订单编号

    private String phone; //手机号码

    private String productNo;//商品编号

    private BigDecimal count; //数量/重量



}
