package com.tingyu.sparkmall.commons.constant;

/**
 * 认证服务常量类
 *
 * @Author essionshy
 * @Create 2020/12/7 21:58
 * @Version renren-fast
 */
public final class AuthServerConstant {

    public static final String LOGINED_USER_INFO = "logined_user_info";
    /**
     * 短信验证码前缀
     */
    public static final String SMS_VERIFY_CODE_KEY_PREFIX = "sms:verifycode:";
    public static final long SMS_VERIFY_CODE_KEY_EXPIRE = 60; //验证码有效期 单位[s]
}
