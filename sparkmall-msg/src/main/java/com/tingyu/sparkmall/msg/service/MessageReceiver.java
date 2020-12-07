package com.tingyu.sparkmall.msg.service;

import org.springframework.messaging.Message;

/**
 * @Author essionshy
 * @Create 2020/12/3 14:32
 * @Version renren-fast
 */

public interface MessageReceiver {

    void receive(Message<Object> message);
}
