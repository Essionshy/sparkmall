package com.tingyu.sparkmall.message.listener;

import com.rabbitmq.client.Channel;
import com.tingyu.sparkmall.commons.dto.order.OrderDTO;
import com.tingyu.sparkmall.message.feign.OrderFeignService;
import com.tingyu.sparkmall.message.service.MessageLogService;
import com.tingyu.sparkmall.message.utils.MessageStatusEnum;
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
    private MessageLogService messageLogService;

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

            String correlationId = (String) message.getMessageProperties().getHeaders().get("spring_returned_message_correlation");
            if (isSuccess) {
                //TODO 消息消费成功，修改消息状态
                messageLogService.updateMessageStatus(correlationId, MessageStatusEnum.ACK_SUCCESS.getCode());
                //取消订单成功
                channel.basicAck(tag, false);
            } else {
                // TODO 消息消费失败，修改状态为消费失败
              messageLogService.updateMessageStatus(correlationId, MessageStatusEnum.ACK_ERROR.getCode());

                channel.basicReject(tag, true);
            }
        }catch (Exception e){

            //远程调用出现异常
            channel.basicReject(tag, true);
        }



    }

}
