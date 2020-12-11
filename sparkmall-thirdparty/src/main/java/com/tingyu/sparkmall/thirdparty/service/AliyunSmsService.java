package com.tingyu.sparkmall.thirdparty.service;

/**
 * @Author essionshy
 * @Create 2020/12/9 12:56
 * @Version renren-fast
 */
public interface AliyunSmsService {

    void sendSmsCode(String phone,String code);
}
