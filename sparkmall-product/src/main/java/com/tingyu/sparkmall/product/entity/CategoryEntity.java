package com.tingyu.sparkmall.product.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @Author essionshy
 * @Create 2020/11/29 11:15
 * @Version renren-fast
 */
@Data
@TableName(value = "tbl_product_category")
public class CategoryEntity {

    @TableId(type = IdType.ASSIGN_ID)
    private Long id; //商品类别ID

    private String name; //商品类别名称

    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date gmtCreate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date gmtModified;


}
