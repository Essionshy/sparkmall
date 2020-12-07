package com.tingyu.sparkmall.order.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.tingyu.sparkmall.commons.support.AbstractEntity;
import lombok.Data;

/**
 * 订单明细实体类
 *
 * @Author essionshy
 * @Create 2020/12/2 17:19
 * @Version renren-fast
 */
@Data
@TableName(value = "tbl_order_items")
public class OrderItemsEntity extends AbstractEntity {

    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    private String orderNo; //订单号

    private String productNo;//商品号

    private Integer count; //商品数量

}
