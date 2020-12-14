package com.tingyu.sparkmall.product.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.tingyu.sparkmall.commons.support.AbstractEntity;
import lombok.Data;

/**
 * @Author essionshy
 * @Create 2020/12/8 0:14
 * @Version renren-fast
 */
@Data
@TableName(value = "tbl_sku_image")
public class SkuImageEntity  extends AbstractEntity {

    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * sku_id
     */
    private Long skuId;
    /**
     * 图片地址
     */
    private String imgUrl;
    /**
     * 排序
     */
    private Integer imgSort;
    /**
     * 默认图[0 - 不是默认图，1 - 是默认图]
     */
    private Integer defaultImg;


}
