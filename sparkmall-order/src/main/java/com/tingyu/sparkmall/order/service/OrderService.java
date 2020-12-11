package com.tingyu.sparkmall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tingyu.sparkmall.commons.utils.PageUtils;
import com.tingyu.sparkmall.order.entity.OrderEntity;

import java.util.Map;

/**
 * 璁㈠崟
 *
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-12-11 16:35:37
 */
public interface OrderService extends IService<OrderEntity> {

    PageUtils queryPage(Map<String, Object> params);

    Integer getOrderStatus(String orderNo);

    void deleteByOrderNo(String orderNo);
}

