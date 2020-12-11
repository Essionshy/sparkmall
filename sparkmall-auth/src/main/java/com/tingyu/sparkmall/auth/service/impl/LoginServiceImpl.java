package com.tingyu.sparkmall.auth.service.impl;

import com.alibaba.fastjson.TypeReference;
import com.tingyu.sparkmall.auth.feign.MemberFeignService;
import com.tingyu.sparkmall.auth.feign.ThirdPartyFeignService;
import com.tingyu.sparkmall.auth.param.MemberLoginParam;
import com.tingyu.sparkmall.auth.param.MemberRegisterParam;
import com.tingyu.sparkmall.auth.service.LoginService;
import com.tingyu.sparkmall.auth.utils.VerifyCodeGeneratorUtils;
import com.tingyu.sparkmall.commons.constant.AuthServerConstant;
import com.tingyu.sparkmall.commons.dto.MemberDTO;
import com.tingyu.sparkmall.commons.exception.ResultException;
import com.tingyu.sparkmall.commons.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @Author essionshy
 * @Create 2020/12/8 12:37
 * @Version renren-fast
 */
@Service
@Slf4j
public class LoginServiceImpl implements LoginService {


    @Resource
    private ThirdPartyFeignService thirdPartyFeignService;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private MemberFeignService memberFeignService;


    /**
     * 发送短信验证码
     *
     * @param phone
     */
    @Override
    public void sendVerifyCode(String phone) {

        String verifyCode = "";
        //TODO 接口防刷
        String key = AuthServerConstant.SMS_VERIFY_CODE_KEY_PREFIX + phone;
        //判断验证码是否是60秒内的，如果是则发送，如果不是
        String value = stringRedisTemplate.opsForValue().get(key);
        //获取验证码时间戳
        if (!StringUtils.isEmpty(value)) {
            //如果验证码存在，则检验验证码的发送频率
            String[] codeArr = value.split("_");
            String timestamp = codeArr[1];
            verifyCode = codeArr[0];

            if (System.currentTimeMillis() - Long.parseLong(timestamp) < 60 * 1000) {

                throw new ResultException(200, "验证码发送频率太高，请稍后再试");

            }

        } else {
            //生成验证码
            verifyCode = VerifyCodeGeneratorUtils.getSixBitCode();
            //保存验证码到Redis  key[sms:verifycode:1531812323]  value[ code_timestamp]
            log.info("生成的验证码：{}", verifyCode);
            String code = verifyCode + "_" + System.currentTimeMillis();
            stringRedisTemplate.opsForValue().set(key, code,
                    AuthServerConstant.SMS_VERIFY_CODE_KEY_EXPIRE, TimeUnit.SECONDS); //10
        }

        //调用第三方短信服务发送验证码 TODO 开启短信验证码功能
         thirdPartyFeignService.sendVerifyCode(phone, verifyCode);


    }

    @Override
    public String register(MemberRegisterParam param, BindingResult result, RedirectAttributes redirectAttributes) {


        //检验参数是否合法
        if (result.hasErrors()) {

            Map<String, String> errors = result.getFieldErrors().
                    stream().collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));

            //页面重定向到注册页面
            //页面重定向携带数据，redirectAttributes
            redirectAttributes.addFlashAttribute("errors", errors);
            return "redirect:http://auth.sparkmall.com/register.html";


        }

        //如果验证为空则返回
        if (StringUtils.isEmpty(param.getVerifyCode())) {
            return "redirect:http://auth.sparkmall.com/register.html";
        }

        //校验验证码是否有效
        String verifyCode = stringRedisTemplate.opsForValue().get(AuthServerConstant.SMS_VERIFY_CODE_KEY_PREFIX + param.getPhone());

        if (verifyCode == null) {
            //验证码失效

            return "redirect:http://auth.sparkmall.com/register.html";
        }

        String code = verifyCode.split("_")[0];

        //校验验证码是否匹配
        if (!code.equalsIgnoreCase(param.getVerifyCode())) {

            throw new ResultException(200, "验证码不正确");
        }

        //验证码校验通过，则删除Redis 中保存的验证码
        stringRedisTemplate.delete(AuthServerConstant.SMS_VERIFY_CODE_KEY_PREFIX + param.getPhone());
        //调用会员远程服务进行注册
        R register = memberFeignService.register(param);


        if (0 == (int) register.get("code")) {
            //注册成功
            log.info("注册成功");
            return "redirect:http://auth.sparkmall.com/login.html";
        } else {
            log.info("注册失败");
            Map<String, String> errors = new HashMap<>();
            String msg = register.getData("msg", new TypeReference<String>() {
            });
            errors.put("errors", msg);

            return "redirect:http://auth.sparkmall.com/register.html";


        }


    }

    @Override
    public String login(@Valid MemberLoginParam param, RedirectAttributes redirectAttributes, HttpSession session) {

        //检验

        Map<String, String> errors = new HashMap<>();

        //调用会员服务远程登录
        MemberDTO loginUser = memberFeignService.login(param);
        if (loginUser == null) {
            //登录失败,重定向到登录页面，并提示账号或密码错误
            log.info("登录失败");
            errors.put("msg", "用户名或密码错误");
            redirectAttributes.addFlashAttribute("errors", errors);
            return "redirect:http://auth.sparkmall.com/login.html";

        } else {
            //登录成功跳转首页
            log.info("登录成功");
            //将用户信息保存到session中
            session.setAttribute("loginUser", loginUser);

            return "redirect:http://sparkmall.com";
        }
    }
}
