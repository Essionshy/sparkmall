package com.tingyu.sparkmall.message.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.tingyu.sparkmall.commons.support.MailMessage;
import com.tingyu.sparkmall.message.entity.MessageLogEntity;
import com.tingyu.sparkmall.message.service.MessageLogService;
import com.tingyu.sparkmall.message.service.MessageProvider;
import com.tingyu.sparkmall.message.utils.MessageStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.messaging.support.MessageHeaderAccessor;
import org.springframework.util.MimeType;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @Author essionshy
 * @Create 2020/12/3 13:14
 * @Version renren-fast
 */

@EnableBinding(Source.class)
@Slf4j
public class MessageProviderImpl implements MessageProvider {


    @Value("${server.port}")
    private int serverPort;
    //注册消息发送通道
    @Resource
    private MessageChannel output; //output 固定

    @Resource
    private MessageLogService messageLogService;
    private boolean isSuccess;

    @Override
    public boolean send(Object message) {
        //根据不同的消息类型，将消息发送到对应的 exchange 中
        MessageLogEntity messageLogEntity = new MessageLogEntity();

        String content = JSONObject.toJSONString(message);
        messageLogEntity.setContent(content);


        if (message instanceof MailMessage) {
            //如果是邮件消息
            MailMessage mailMessage = (MailMessage) message;

            MessageHeaderAccessor headerAccessor=new MessageHeaderAccessor();

            headerAccessor.setContentType(MimeType.valueOf("application/json"));
            Message<MailMessage> build = MessageBuilder.withPayload(mailMessage).build();


            messageLogEntity.setExchangeName(output.toString());
            //邮件消息发送通道发送邮件消息

            isSuccess = output.send(build);
            log.info("消息发送者：发送消息完成...");


        } else {


            String serial = UUID.randomUUID().toString();

            Message<String> msg = MessageBuilder.withPayload(serial).build();

            isSuccess = output.send(msg);


        }


        if (isSuccess) {
            log.info("消息提供者 {} 发送消息 serial:{} 成功！！", serverPort);
            messageLogEntity.setStatus(MessageStatusEnum.DELIVER_SUCCESS.getCode());
        } else {
            //记录消息日志
            messageLogEntity.setStatus(MessageStatusEnum.DELIVER_ERROR.getCode());
            log.info("消息提供者 {} 发送消息 serial:{} 失败！！", serverPort);

        }
        messageLogService.save(messageLogEntity);
        return isSuccess;
    }
}
