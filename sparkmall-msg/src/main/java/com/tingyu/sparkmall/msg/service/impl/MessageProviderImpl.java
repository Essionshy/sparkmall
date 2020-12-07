package com.tingyu.sparkmall.msg.service.impl;

import com.tingyu.sparkmall.commons.support.MailMessage;
import com.tingyu.sparkmall.msg.service.MessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

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
    private boolean isSuccess;

    @Override
    public boolean send(Object message) {
        //根据不同的消息类型，将消息发送到对应的 exchange 中

        if (message instanceof MailMessage) {
            //如果是邮件消息
            MailMessage mailMessage = (MailMessage) message;
            Message<MailMessage> build = MessageBuilder.withPayload(mailMessage).build();


            //邮件消息发送通道发送邮件消息

            isSuccess = output.send(build);
            log.info("消息发送者：发送消息完成...");

        } else {


            String serial = UUID.randomUUID().toString();

            Message<String> msg = MessageBuilder.withPayload(serial).build();

            isSuccess = output.send(msg);

            if (isSuccess) {
                log.info("消息提供者 {} 发送消息 serial:{} 成功！！", serverPort, serial);
            } else {
                log.info("消息提供者 {} 发送消息 serial:{} 失败！！", serverPort, serial);

            }
        }


        return isSuccess;
    }
}
