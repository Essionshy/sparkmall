package com.tingyu.sparkmall.mail.service;

import com.tingyu.sparkmall.commons.support.MailMessage;

/**
 * @Author essionshy
 * @Create 2020/12/3 16:54
 * @Version renren-fast
 */
public interface MailService {

    void send(MailMessage message);
}
