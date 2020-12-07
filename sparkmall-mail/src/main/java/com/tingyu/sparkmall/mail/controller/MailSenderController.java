package com.tingyu.sparkmall.mail.controller;

import com.tingyu.sparkmall.commons.support.MailMessage;
import com.tingyu.sparkmall.mail.service.MailService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author essionshy
 * @Create 2020/12/3 20:57
 * @Version renren-fast
 */

@RequestMapping("mail")
@RestController
public class MailSenderController {

    @Resource
    private MailService mailService;

    @ApiOperation("邮件发送")
    @PostMapping("send")
    public void send(@RequestBody MailMessage message) {
        mailService.send(message);
    }

}
