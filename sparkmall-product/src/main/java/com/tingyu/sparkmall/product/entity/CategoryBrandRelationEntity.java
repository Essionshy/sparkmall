package com.tingyu.sparkmall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.tingyu.sparkmall.commons.support.AbstractEntity;
import lombok.Data;

/**
 * @Author essionshy
 * @Create 2020/12/8 0:19
 * @Version renren-fast
 */
@Data
@TableName(value = "tbl_category_brand_relation")
public class CategoryBrandRelationEntity extends AbstractEntity {

    /**
     * ID
     */
    @TableId
    private Long id;
    /**
     * 品牌id
     */
    private Long brandId;
    /**
     * 分类id
     */
    private Long catelogId;
    /**
     *
     */
    private String brandName;
    /**
     *
     */
    private String catelogName;


}
