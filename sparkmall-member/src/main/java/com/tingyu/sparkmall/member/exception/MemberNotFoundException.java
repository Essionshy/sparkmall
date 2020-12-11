package com.tingyu.sparkmall.member.exception;

/**
 * @Author essionshy
 * @Create 2020/12/11 20:25
 * @Version sparkmall
 */
public class MemberNotFoundException extends RuntimeException {

    public MemberNotFoundException() {
        super("会员不存在");
    }
}
