package com.tingyu.sparkmall.order.service;

import com.tingyu.sparkmall.order.param.OrderParam;

/**
 * @Author essionshy
 * @Create 2020/11/27 22:29
 * @Version renren-fast
 */
public interface OrderService {


    boolean create(OrderParam param);

    boolean deleteByOrderNo(String orderNo);
}
