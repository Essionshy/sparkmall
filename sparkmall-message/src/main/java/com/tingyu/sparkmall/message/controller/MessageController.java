package com.tingyu.sparkmall.message.controller;

import com.tingyu.sparkmall.commons.dto.message.MessageLogDTO;
import com.tingyu.sparkmall.commons.support.CommonResult;
import com.tingyu.sparkmall.message.service.MessageService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author essionshy
 * @Create 2020/12/14 20:32
 * @Version sparkmall
 */

@RestController
@RequestMapping("message")
public class MessageController {



    @Resource
    private MessageService messageService;

    @ApiOperation("消息发送")
    @PostMapping("/send")
    public CommonResult sendMessage(@RequestBody Object message){
        messageService.sendMessage(message);
        return CommonResult.success();
    }


    @ApiOperation("消息重发")
    @PostMapping("/retry")
    public CommonResult retrySendMessage(@RequestBody MessageLogDTO messageLogDTO){
        messageService.retrySendMessage(messageLogDTO);
        return CommonResult.success();
    }

}
