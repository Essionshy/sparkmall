package com.tingyu.sparkmall.message.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.tingyu.sparkmall.commons.support.MailMessage;
import com.tingyu.sparkmall.message.feign.MailFeignService;
import com.tingyu.sparkmall.msg.service.MessageReceiver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;

import javax.annotation.Resource;

/**
 * @Author essionshy
 * @Create 2020/12/3 14:33
 * @Version renren-fast
 */

@EnableBinding(Sink.class)
@Slf4j
public class MessageReceiverImpl implements MessageReceiver {


    @Resource
    private MailFeignService mailFeignService;

    @StreamListener(Sink.INPUT)
    @Override
    public void receive(Message<Object> message) {


        log.info(message.getClass().getName());
        Object payload = message.getPayload();


        log.info(payload.getClass().getName());
        log.info(payload.toString());
        String msg = (String) payload;
        MailMessage mailMessage = JSONObject.parseObject(msg, MailMessage.class);

        mailFeignService.send(mailMessage);


    }
}
