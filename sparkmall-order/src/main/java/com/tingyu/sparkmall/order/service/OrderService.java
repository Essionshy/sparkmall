package com.tingyu.sparkmall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tingyu.sparkmall.commons.dto.order.OrderDTO;
import com.tingyu.sparkmall.commons.utils.PageUtils;
import com.tingyu.sparkmall.order.entity.OrderEntity;

import java.util.Map;

/**
 * 订单
 *
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-12-13 14:22:07
 */
public interface OrderService extends IService<OrderEntity> {

    PageUtils queryPage(Map<String, Object> params);

    Integer getOrderStatus(String orderNo);

    void deleteByOrderNo(String orderNo);

    /**
     * 创建订单
     * @param order
     */
    void create(OrderDTO order);
}

