package com.tingyu.sparkmall.auth.param;

import lombok.Data;

/**
 * @Author essionshy
 * @Create 2020/12/8 20:37
 * @Version renren-fast
 */
@Data
public class MemberLoginParam {

    /**
     * 账号： 用户名或手机号或邮箱
     */
    private String account;

    /**
     * 密码
     */
    private String password;

}
