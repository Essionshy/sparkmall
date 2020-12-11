package com.tingyu.sparkmall.auth.controller;

import com.tingyu.sparkmall.auth.param.MemberLoginParam;
import com.tingyu.sparkmall.auth.param.MemberRegisterParam;
import com.tingyu.sparkmall.auth.service.LoginService;
import com.tingyu.sparkmall.commons.utils.R;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * @Author essionshy
 * @Create 2020/12/8 10:22
 * @Version renren-fast
 */
@Controller
public class LoginController {

    @Resource
    private LoginService loginService;

    @ApiOperation("发送短信验证码")
    @GetMapping("sms/send/code/{phone}")
    public R sendVerifyCode(@PathVariable("phone") String phone) {
        loginService.sendVerifyCode(phone);
        return R.ok();
    }



    @ApiOperation("用户注册")
    @PostMapping("/register")
    public String register(@Valid MemberRegisterParam param, BindingResult result, RedirectAttributes redirectAttributes) {

       return loginService.register(param, result, redirectAttributes);

    }

    @ApiOperation("用户登录")
    @PostMapping("/login")
    public String login(MemberLoginParam param, RedirectAttributes redirectAttributes, HttpSession session){
       return loginService.login(param,redirectAttributes,session);

    }

}
