package com.tingyu.sparkmall.thirdparty.service.impl;

import com.tingyu.sparkmall.thirdparty.service.AliyunSmsService;
import com.tingyu.sparkmall.thirdparty.utils.SmsUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 阿里云短信服务
 *
 * @Author essionshy
 * @Create 2020/12/9 12:56
 * @Version renren-fast
 */
@Service
@Slf4j
public class AliyunSmsServiceImpl implements AliyunSmsService {


    @Override
    public void sendSmsCode(String phone, String code) {

        SmsUtils.sendSmsCode(phone, code);

    }
}
