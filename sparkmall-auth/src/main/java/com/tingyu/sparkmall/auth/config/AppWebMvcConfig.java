package com.tingyu.sparkmall.auth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author essionshy
 * @Create 2020/12/8 11:48
 * @Version renren-fast
 */
@Configuration
public class AppWebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        /**
         * 注册请求跳转页面
         */
        registry.addViewController("/login.html").setViewName("login");
        registry.addViewController("/register.html").setViewName("register");
    }
}
