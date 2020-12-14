package com.tingyu.sparkmall.commons.dto.product;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author essionshy
 * @Create 2020/12/11 22:28
 * @Version sparkmall
 */
@Data
public class SkuInfoDTO {
    private Long id;
    /**
     * spuId
     */
    private Long spuId;
    /**
     * sku名称
     */
    private String name;
    /**
     * 所属分类id
     */
    private Long catagoryId;
    /**
     * 品牌id
     */
    private Long brandId;
    /**
     * 默认图片
     */
    private String defaultImage;
    /**
     * 标题
     */
    private String title;
    /**
     * 副标题
     */
    private String subtitle;
    /**
     * 价格
     */
    private BigDecimal price;
    /**
     * 重量（克）
     */
    private Integer weight;
}
