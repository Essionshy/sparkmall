package com.tingyu.sparkmall.order.dao;

import com.tingyu.sparkmall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-12-13 14:22:07
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {

    void getOrderStatus(String orderNo);
}
