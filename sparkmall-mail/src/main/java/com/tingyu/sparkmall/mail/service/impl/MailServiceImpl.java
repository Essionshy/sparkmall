package com.tingyu.sparkmall.mail.service.impl;

import com.tingyu.sparkmall.commons.support.MailMessage;
import com.tingyu.sparkmall.mail.config.MailConfig;
import com.tingyu.sparkmall.mail.service.MailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author essionshy
 * @Create 2020/12/3 16:48
 * @Version renren-fast
 */

@Service
@Slf4j
public class MailServiceImpl implements MailService {

    @Resource
    private JavaMailSender mailSender;

    @Override
    public void send(MailMessage msg) {

        if (null == msg) {
            return;
        }
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(msg.getTo());
        message.setText(msg.getContent());
        message.setSubject(msg.getSubject());
        message.setFrom(MailConfig.DEFAULT_USERNAME);

        try {
            mailSender.send(message);
        } catch (Exception e) {
            e.printStackTrace();

        }


    }


}
