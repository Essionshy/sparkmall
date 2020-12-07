package com.tingyu.sparkmall.commons.support.enums;

/**
 * 邮件消息类型
 *
 * @Author essionshy
 * @Create 2020/12/3 17:19
 * @Version renren-fast
 */
public enum MailMessageType {

    //用户注册邮件消息
    USER_REGISTER,

    //账号异常
    ACCOUNT_EXCEPTION,

    //密码变更
    PASSWORD_CHANGED,

    //密码找回
    PASSWORD_FIND,

    //创建订单成功通知
    ORDER_CREATE,

    //订单取消通知
    ORDER_CANCEL,

    //支付成功通知
    PAY_SUCCESS,

    COMMON;


}
