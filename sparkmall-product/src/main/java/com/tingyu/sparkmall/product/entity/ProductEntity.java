package com.tingyu.sparkmall.product.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author essionshy
 * @Create 2020/4/22 18:25
 * @Version sparkmall
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
@ToString
@Accessors(chain = true)
@TableName(value = "tbl_product_item")
public class ProductEntity {

    /**
     * 商品ID
     */
    @TableId(type = IdType.AUTO)
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


    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date gmtCreate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date gmtModified;
}
