package com.tingyu.sparkmall.message.listener;

import com.alibaba.fastjson.JSONObject;
import com.rabbitmq.client.Channel;
import com.tingyu.sparkmall.commons.dto.order.OrderDTO;
import com.tingyu.sparkmall.message.feign.OrderFeignService;
import com.tingyu.sparkmall.message.service.MessageLogService;
import com.tingyu.sparkmall.message.utils.MessageStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;


/**
 * @Author essionshy
 * @Create 2020/12/14 12:10
 * @Version sparkmall
 */

@Component
@RabbitListener(queues = {"order-create-queue"})
@Slf4j
public class OrderCreateListener {


    @Resource
    private OrderFeignService orderFeignService;

    @Resource
    private MessageLogService messageLogService;

    /**
     *  消费者监听的队列来区分具体的消息
     * @param content
     * @param message
     * @param channel
     * @throws IOException
     */
    @RabbitHandler
    public void handleOrderCreate(String content, Message message, Channel channel) throws IOException {



            OrderDTO order = JSONObject.parseObject(content, OrderDTO.class);
            long tag = message.getMessageProperties().getDeliveryTag();
            log.info("delivery tag :{}", tag);
            String msgId = (String) message.getMessageProperties().getHeaders().get("spring_returned_message_correlation");
            try {
                orderFeignService.createOrder(order);
                //修改消息状态为消费成功
                messageLogService.updateMessageStatus(msgId, MessageStatusEnum.ACK_SUCCESS.getCode());
                //手动确认签收消息
                channel.basicAck(tag, false);

            } catch (Exception e) {
                e.printStackTrace();
                messageLogService.updateMessageStatus(msgId, MessageStatusEnum.ACK_ERROR.getCode());
                channel.basicReject(tag, true);

            }
    }

}
