package com.tingyu.sparkmall.member.exception;

/**
 * @Author essionshy
 * @Create 2020/12/8 14:57
 * @Version renren-fast
 */

public class UsernameExistsException extends RuntimeException {
    public UsernameExistsException() {
        super("用户名已存在！！！");
    }
}
