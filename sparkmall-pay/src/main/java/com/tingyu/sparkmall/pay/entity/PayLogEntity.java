package com.tingyu.sparkmall.pay.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.tingyu.sparkmall.commons.support.AbstractEntity;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author essionshy
 * @Create 2020/12/2 20:55
 * @Version renren-fast
 */
@Data
@TableName(value = "tbl_pay_log")
public class PayLogEntity extends AbstractEntity {

    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    private Integer status; //0 支付成功，1 支付失败

    private BigDecimal totalAmount; //支付金额

}
