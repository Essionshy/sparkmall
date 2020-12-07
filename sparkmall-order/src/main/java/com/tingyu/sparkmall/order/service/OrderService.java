package com.tingyu.sparkmall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tingyu.sparkmall.commons.dto.OrderDTO;
import com.tingyu.sparkmall.order.entity.OrderEntity;
import com.tingyu.sparkmall.order.param.OrderParam;

/**
 * @Author essionshy
 * @Create 2020/11/27 22:29
 * @Version renren-fast
 */
public interface OrderService extends IService<OrderEntity> {


    boolean create(OrderParam param);

    boolean deleteByOrderNo(String orderNo);


    OrderDTO getByOrderNo(String orderNo);

    boolean updateOrderStatus(String orderNo, int status);
}
