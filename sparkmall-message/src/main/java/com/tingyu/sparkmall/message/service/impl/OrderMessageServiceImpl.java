package com.tingyu.sparkmall.message.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.tingyu.sparkmall.commons.dto.order.OrderDTO;
import com.tingyu.sparkmall.message.config.OrderRabbitConfig;
import com.tingyu.sparkmall.message.entity.MessageLogEntity;
import com.tingyu.sparkmall.message.service.MessageLogService;
import com.tingyu.sparkmall.message.service.OrderMessageService;
import com.tingyu.sparkmall.message.utils.MessageStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @Author essionshy
 * @Create 2020/12/14 12:03
 * @Version sparkmall
 */

@Service
@Slf4j
public class OrderMessageServiceImpl implements OrderMessageService {

    @Resource
    private RabbitTemplate rabbitTemplate;

    @Resource
    private MessageLogService messageLogService;

    // 消息发送异常，不能让其回滚吧
    // @Transactional
    @Override
    public void sendOrderCreate(OrderDTO orderDTO) {

        //判断是否为失败重发消息



        //先保存消息日志，默认创建成功，如何出现异常再更新该消息的状态；
        MessageLogEntity messageLogEntity = new MessageLogEntity();
        messageLogEntity.setContent(JSONObject.toJSONString(orderDTO));
        String msgId = UUID.randomUUID().toString().replace("-", "");
        messageLogEntity.setMsgId(msgId);
        messageLogEntity.setExchangeName(OrderRabbitConfig.EXCHANGE);
        messageLogEntity.setRoutingKey(OrderRabbitConfig.CREATE_ROUTING_KEY);
        messageLogEntity.setDestination(OrderRabbitConfig.CREATE_QUEUE);
        messageLogEntity.setDestinationType(Binding.DestinationType.QUEUE.ordinal());
        messageLogEntity.setStatus(MessageStatusEnum.DELIVER_SUCCESS.getCode());
        messageLogService.save(messageLogEntity);

        try {

             rabbitTemplate.convertAndSend(OrderRabbitConfig.EXCHANGE, OrderRabbitConfig.CREATE_ROUTING_KEY, orderDTO,new CorrelationData(msgId));
            //默认消息状态为创建成功
        } catch (Exception e) {
            e.printStackTrace();
            //如果出现异常，则修改消息状态
            messageLogService.updateMessageStatus(msgId, MessageStatusEnum.DELIVER_ERROR.getCode());

        }


    }



    @Override
    public void sendOrderDelayMsg(OrderDTO orderDTO) {

        //先保存消息日志，默认创建成功，如何出现异常再更新该消息的状态；
        MessageLogEntity messageLogEntity = new MessageLogEntity();
        messageLogEntity.setContent(JSONObject.toJSONString(orderDTO));
        String msgId = UUID.randomUUID().toString().replace("-", "");
        messageLogEntity.setMsgId(msgId);
        messageLogEntity.setExchangeName(OrderRabbitConfig.EXCHANGE);
        messageLogEntity.setRoutingKey(OrderRabbitConfig.DELAY_ROUTING_KEY);
        messageLogEntity.setDestination(OrderRabbitConfig.DELAY_QUEUE);
        messageLogEntity.setDestinationType(Binding.DestinationType.QUEUE.ordinal());
        messageLogEntity.setStatus(MessageStatusEnum.DELIVER_SUCCESS.getCode());
        messageLogService.save(messageLogEntity);

        try {

            rabbitTemplate.convertAndSend(OrderRabbitConfig.EXCHANGE, OrderRabbitConfig.DELAY_ROUTING_KEY, orderDTO,new CorrelationData(msgId));
            //默认消息状态为创建成功
        } catch (Exception e) {
            e.printStackTrace();
            //如果出现异常，则修改消息状态
            messageLogService.updateMessageStatus(msgId, MessageStatusEnum.DELIVER_ERROR.getCode());

        }

    }
}
