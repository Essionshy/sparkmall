package com.tingyu.sparkmall.member.exception;

/**
 * @Author essionshy
 * @Create 2020/12/11 20:28
 * @Version sparkmall
 */
public class PasswordNotMatchedException extends RuntimeException {

    public PasswordNotMatchedException() {
        super("密码不匹配");
    }
}
