package com.tingyu.sparkmall.coupon.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.tingyu.sparkmall.commons.support.AbstractEntity;
import lombok.Data;

import java.util.Date;

/**
 * 积分明细表
 *
 * @Author essionshy
 * @Create 2020/12/5 12:29
 * @Version renren-fast
 */
@Data
@TableName(value = "tbl_coupon_items")
public class CounponItemsEntity extends AbstractEntity {

    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    private Integer source;// 积分来源

    private Date createTime; //生成时间

}
