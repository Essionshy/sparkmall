package com.tingyu.sparkmall.cart.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @Author essionshy
 * @Create 2020/12/2 11:52
 * @Version renren-fast
 */
@Data
public class CartVo implements Serializable {

    private List<CartItemVo> items; //商品列表

    private Integer itemCount;// 商品种类数量

    private Integer typeCount;// 商品总数

    private BigDecimal totalAmount; //商品总金额

    private BigDecimal discount; //优惠金额


}
