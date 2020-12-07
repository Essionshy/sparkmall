package com.tingyu.sparkmall.commons.support;

import com.tingyu.sparkmall.commons.support.enums.MailMessageType;
import lombok.Data;

/**
 * 封装发送的消息中间件的邮件消息
 *
 * @Author essionshy
 * @Create 2020/12/3 17:17
 * @Version renren-fast
 */

@Data
public class MailMessage {

    private Long msgId; //消息ID

    private String to; //邮件接收方

    private String subject; //主题

    private String content;//内容

    private MailMessageType type; //邮件消息类型


}
