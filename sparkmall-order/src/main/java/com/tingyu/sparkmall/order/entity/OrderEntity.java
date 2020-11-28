package com.tingyu.sparkmall.order.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author essionshy
 * @Create 2020/11/27 22:37
 * @Version renren-fast
 */
@Data
@TableName(value = "tbl_order")
public class OrderEntity {

    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    private String orderNo; //订单编号

    private String username; //用户名

    private String phone; //手机号码

    private String productNo;//商品编号

    private BigDecimal count; //数量/重量

    private BigDecimal totalFee; //总金额

    private Integer payType; //支付方式

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate; //创建时间

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified; //更新时间





}
