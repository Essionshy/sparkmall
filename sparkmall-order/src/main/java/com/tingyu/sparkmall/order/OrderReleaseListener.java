package com.tingyu.sparkmall.order;

import com.rabbitmq.client.Channel;
import com.tingyu.sparkmall.commons.support.enums.OrderStatus;
import com.tingyu.sparkmall.order.entity.OrderEntity;
import com.tingyu.sparkmall.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @Author essionshy
 * @Create 2020/12/9 0:41
 * @Version renren-fast
 */
@Component
@Slf4j
public class OrderReleaseListener {

    @Resource
    private OrderService orderService;

    @RabbitListener(queues = "order-release-queue")
    public void release(OrderEntity order, Message message, Channel channel) {

        try {

            String orderNo = order.getOrderNo();
            log.info("消费订单，订单号：{}", orderNo);

            long tag = message.getMessageProperties().getDeliveryTag();
            channel.basicAck(tag, false);
            //TODO 根据订单号查询订单状态，如果订单未支付，则删除该条订单
            Integer orderStatus = orderService.getOrderStatus(orderNo);
            if(orderStatus!= OrderStatus.PAYED.ordinal()){
                //订单未支付，删除该订单
                orderService.deleteByOrderNo(orderNo);

            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
