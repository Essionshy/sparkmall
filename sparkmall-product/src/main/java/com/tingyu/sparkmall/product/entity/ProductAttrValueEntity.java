package com.tingyu.sparkmall.product.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.tingyu.sparkmall.commons.support.AbstractEntity;
import lombok.Data;

/**
 * 商品属性值实体类
 * @Author essionshy
 * @Create 2020/12/8 0:17
 * @Version renren-fast
 */
@Data
@TableName(value = "tbl_product_attr_value")
public class ProductAttrValueEntity extends AbstractEntity {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 商品id
     */
    private Long spuId;
    /**
     * 属性id
     */
    private Long attrId;
    /**
     * 属性名
     */
    private String attrName;
    /**
     * 属性值
     */
    private String attrValue;
    /**
     * 顺序
     */
    private Integer attrSort;
    /**
     * 快速展示【是否展示在介绍上；0-否 1-是】
     */
    private Integer quickShow;


}
