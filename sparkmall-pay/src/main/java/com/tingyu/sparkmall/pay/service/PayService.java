package com.tingyu.sparkmall.pay.service;

/**
 * @Author essionshy
 * @Create 2020/12/1 23:07
 * @Version renren-fast
 */
public interface PayService {
    String pay(String orderNo, Integer payType);

    void success(String orderNo);

}
