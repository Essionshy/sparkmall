package com.tingyu.sparkmall.msg.controller;

import com.tingyu.sparkmall.commons.support.MailMessage;
import com.tingyu.sparkmall.msg.service.MessageProvider;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author essionshy
 * @Create 2020/12/3 13:18
 * @Version renren-fast
 */

@RequestMapping("msg")
@RestController
public class MessageController {


    @Resource
    private MessageProvider messageProvider;

    @ApiOperation("消息发送")
    @PostMapping("send")
    public boolean send(@RequestBody MailMessage message) {
        boolean isSuccess = messageProvider.send(message);//发送消息
        return isSuccess;
    }

    @ApiOperation("测试")
    @GetMapping("get")
    // @SentinelResource(value = "get")
    public String get() {

        return "测试消息服务器调用邮件服务出现异常后，是否影响不调用邮件服务的请求";
    }
}
