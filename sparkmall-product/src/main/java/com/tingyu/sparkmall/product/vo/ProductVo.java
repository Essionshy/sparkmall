package com.tingyu.sparkmall.product.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author essionshy
 * @Create 2020/11/29 11:50
 * @Version renren-fast
 */
@Data
public class ProductVo implements Serializable {

    /**
     * 商品ID
     */
    private Long id;

    /**
     * 商品编号
     */
    private String productNo;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 商品类别ID
     */
    private Long categoryId;


    /**
     * 商品生产厂家
     */
    private String manufacturer;

    /**
     * 商品生产日期
     */
    private Date manufactureDate;

    /**
     * 商品保质期
     */
    private Integer validityMonth;

    /**
     * 商品价格
     */
    private BigDecimal price;


    private Date gmtCreate;


    private Date gmtModified;
}
