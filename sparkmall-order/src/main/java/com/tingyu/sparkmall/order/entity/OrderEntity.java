package com.tingyu.sparkmall.order.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.tingyu.sparkmall.commons.support.AbstractEntity;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 订单实体类
 *
 * @Author essionshy
 * @Create 2020/11/27 22:37
 * @Version renren-fast
 */
@Data
@TableName(value = "tbl_order")
public class OrderEntity extends AbstractEntity {

    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    private String orderNo; //订单编号

    private String username; //用户名

    private String phone; //手机号码


    private Integer totalCount; //订单商品总件数

    private BigDecimal totalFee; //订单总金额

    private Integer payType; //支付方式

    private Integer status; //订单状态


}
