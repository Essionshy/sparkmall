package com.tingyu.sparkmall.message.service.impl;

import com.tingyu.sparkmall.commons.dto.message.MessageLogDTO;
import com.tingyu.sparkmall.message.service.MessageLogService;
import com.tingyu.sparkmall.message.service.MessageService;
import com.tingyu.sparkmall.message.utils.MessageStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author essionshy
 * @Create 2020/12/14 20:34
 * @Version sparkmall
 */
@Service
@Slf4j
public class MessageServiceImpl implements MessageService {

    @Resource
    private RabbitTemplate rabbitTemplate;

    @Resource
    private MessageLogService messageLogService;

    @Override
    public void sendMessage(Object message) {





    }

    @Override
    public void retrySendMessage(MessageLogDTO message) {
        if (null == message) {
            return;
        }
        String msgId = message.getMsgId();
        try {

            String content = message.getContent();

            rabbitTemplate.convertAndSend(message.getExchangeName(), message.getRoutingKey(), content, new CorrelationData(msgId));

            messageLogService.updateMessageStatus(msgId, MessageStatusEnum.DELIVER_SUCCESS.getCode());

            //默认消息状态为创建成功
        } catch (Exception e) {
            e.printStackTrace();
            //如果出现异常，则修改消息状态
            messageLogService.updateMessageStatus(msgId, MessageStatusEnum.DELIVER_ERROR.getCode());

        }
    }
}
