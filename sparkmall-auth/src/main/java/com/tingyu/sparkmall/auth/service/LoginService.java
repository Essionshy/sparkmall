package com.tingyu.sparkmall.auth.service;

import com.tingyu.sparkmall.auth.param.MemberLoginParam;
import com.tingyu.sparkmall.auth.param.MemberRegisterParam;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * @Author essionshy
 * @Create 2020/12/8 12:37
 * @Version renren-fast
 */
public interface LoginService {
    /**
     * 发送短信验证码
     * @param phone
     */
    void sendVerifyCode(String phone);

    /**
     * 会员注册
     *
     * @param param
     * @param result
     * @param redirectAttributes
     */
     String register(MemberRegisterParam param, BindingResult result, RedirectAttributes redirectAttributes);

    /**
     * 会员登录
     * @param param
     * @param redirectAttributes
     * @param session
     * @return
     */
    String login(MemberLoginParam param, RedirectAttributes redirectAttributes, HttpSession session);
}
