package com.tingyu.sparkmall.member.exception;

/**
 * @Author essionshy
 * @Create 2020/12/8 14:58
 * @Version renren-fast
 */
public class PhoneExistsException extends RuntimeException {
    public PhoneExistsException() {
        super("手机号已存在");
    }
}
