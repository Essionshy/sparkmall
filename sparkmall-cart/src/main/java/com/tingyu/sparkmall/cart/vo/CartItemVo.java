package com.tingyu.sparkmall.cart.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 购物车购物项
 *
 * @Author essionshy
 * @Create 2020/12/7 18:56
 * @Version renren-fast
 */
@Data
public class CartItemVo implements Serializable {

    private Long skuId; //商品skuId

    private Boolean checked = false; //是否选中

    private String title; //商品标题

    private String image; //商品图片

    private BigDecimal price;// 商品价格

    private Integer count;//购物项数量

    private BigDecimal subtotal; //购物项总金额小计

    private List<String> skuAttr; //销售属性


    public CartItemVo() {
    }

}
