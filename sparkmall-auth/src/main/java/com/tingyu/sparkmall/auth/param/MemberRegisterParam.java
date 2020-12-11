package com.tingyu.sparkmall.auth.param;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * 用户注册表单参数对象类
 * @Author essionshy
 * @Create 2020/12/8 14:17
 * @Version renren-fast
 */
@Data
public class MemberRegisterParam {

    /**
     * 用户名
     */
    @NotEmpty(message = "用户名不能为空")
    private String username;

    /**
     * 手机号
     */
    @NotEmpty(message = "手机号不能为空")
    private String phone;

    /**
     * 密码
     */
    @NotEmpty(message = "密码不能为空")
    private String password;

    /**
     * 验证码
     */
    @NotEmpty(message = "验证码不能为空")
    private String verifyCode;


}
