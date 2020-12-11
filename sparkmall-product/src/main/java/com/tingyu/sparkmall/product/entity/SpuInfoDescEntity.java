package com.tingyu.sparkmall.product.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.tingyu.sparkmall.commons.support.AbstractEntity;
import lombok.Data;

/**
 * 商品SPU 描述实体类
 * @Author essionshy
 * @Create 2020/12/8 0:08
 * @Version renren-fast
 */
@Data
@TableName(value = "tbl_spu_info_desc")
public class SpuInfoDescEntity extends AbstractEntity {

    /**
     * 商品id
     */
    @TableId(type = IdType.INPUT)
    private Long spuId;
    /**
     * 商品介绍
     */
    private String decription;

}
