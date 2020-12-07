package com.tingyu.sparkmall.cart.param;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author essionshy
 * @Create 2020/12/2 0:32
 * @Version renren-fast
 */
@Data
public class CartParam {

    private String memberNo; //会员号

    private String productNo; //商品号

    private BigDecimal price; //商品价格

    private Long count; //数量; 如果是增加或者减少商品数量 ，每次 增1 或减1

    private BigDecimal amount;// 某项商品总金额

}
