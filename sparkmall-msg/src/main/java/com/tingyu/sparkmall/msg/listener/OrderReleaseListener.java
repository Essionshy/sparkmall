package com.tingyu.sparkmall.msg.listener;

import com.rabbitmq.client.Channel;
import com.tingyu.sparkmall.commons.dto.OrderDTO;
import com.tingyu.sparkmall.msg.feign.OrderFeignService;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @Author essionshy
 * @Create 2020/12/11 11:09
 * @Version renren-fast
 */
@RabbitListener(queues = {"order-release-queue"})
public class OrderReleaseListener {


    @Resource
    private OrderFeignService orderFeignService;

    /**
     * 订单关单操作
     */
    @RabbitHandler
    public void handleCloseOrder(OrderDTO order, Message message, Channel channel) throws IOException {
        long tag = message.getMessageProperties().getDeliveryTag(); //消息标签

        try{
            boolean isSuccess = orderFeignService.closeOrder(order.getOrderNo());

            if (isSuccess) {
                //取消订单成功
                channel.basicAck(tag, false);
            } else {

                channel.basicReject(tag, true);
            }
        }catch (Exception e){
            //远程调用出现异常
            channel.basicReject(tag, true);
        }



    }

}
