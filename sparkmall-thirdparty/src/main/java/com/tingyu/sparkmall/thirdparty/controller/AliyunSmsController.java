package com.tingyu.sparkmall.thirdparty.controller;

import com.tingyu.sparkmall.commons.utils.R;
import com.tingyu.sparkmall.thirdparty.service.AliyunSmsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 短信发送服务
 * @Author essionshy
 * @Create 2020/12/8 12:42
 * @Version renren-fast
 */
@RestController
@RequestMapping("/sms")
public class AliyunSmsController {

    @Resource
    private AliyunSmsService aliyunSmsService;

    @GetMapping("/send/code/{phone}/{code}")
    public R sendVerifyCode(@PathVariable("phone") String phone,@PathVariable("code") String code){
        aliyunSmsService.sendSmsCode(phone,code);
        return R.ok();
    }

}
