package com.tingyu.sparkmall.mail.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 * @Author essionshy
 * @Create 2020/12/3 16:49
 * @Version renren-fast
 */
@Configuration
public class AppConfig {


    @Bean
    public JavaMailSender mailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setProtocol(MailConfig.DEFAULT_PROTOCOL);
        mailSender.setHost(MailConfig.DEFAULT_HOST);
        // mailSender.setPort(MailConfig.DEFAULT_PORT);
        mailSender.setDefaultEncoding(MailConfig.DEFAULT_CHARSET);
        mailSender.setPassword(MailConfig.DEFAULT_PASSWORD);
        mailSender.setUsername(MailConfig.DEFAULT_USERNAME);
        return mailSender;
    }


}
