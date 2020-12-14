package com.tingyu.sparkmall.message.service;

import com.tingyu.sparkmall.commons.dto.message.MessageLogDTO;

/**
 * @Author essionshy
 * @Create 2020/12/14 20:34
 * @Version sparkmall
 */
public interface MessageService {


    /**
     * 发送消息
     * @param message
     */
    void sendMessage(Object message);

    /**
     * 重发消息
     * @param messageLogDTO
     */
    void retrySendMessage(MessageLogDTO messageLogDTO);

}
