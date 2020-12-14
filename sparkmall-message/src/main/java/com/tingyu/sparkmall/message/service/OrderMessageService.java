package com.tingyu.sparkmall.message.service;

import com.tingyu.sparkmall.commons.dto.order.OrderDTO;

/**
 * @Author essionshy
 * @Create 2020/12/14 12:03
 * @Version sparkmall
 */
public interface OrderMessageService {
    /**
     * 发送创建订单消息
     * @param orderDTO
     */
    void sendOrderCreate(OrderDTO orderDTO);


    /**
     * 发送定时关单消息到延时队列
     * @param orderDTO
     */
    void sendOrderDelayMsg(OrderDTO orderDTO);
}
