package com.tingyu.sparkmall.ware.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 库存实体类
 *
 * @Author essionshy
 * @Create 2020/11/27 23:18
 * @Version renren-fast
 */
@Data
@TableName(value = "tbl_ware")
public class WareEntity {

    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    private String name;

    private String productNo; //商品编号


    private BigDecimal total; //库存总量

    private BigDecimal used; //库存使用量

    private Integer status;

    private Integer deleted;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;

}
