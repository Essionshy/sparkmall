package com.tingyu.sparkmall.coupon.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.tingyu.sparkmall.commons.support.AbstractEntity;
import lombok.Data;

/**
 * @Author essionshy
 * @Create 2020/12/5 11:59
 * @Version renren-fast
 */
@Data
@TableName(value = "tbl_coupon")
public class CouponEntity extends AbstractEntity {

    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    private String memberNo; //会员号

    private String phone; //手机号

    private Long count; //积分数量

    private Long used; //积分使用量


}
