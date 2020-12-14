package com.tingyu.sparkmall.seckill.config;

import com.tingyu.sparkmall.seckill.interceptor.SeckillLoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @Author essionshy
 * @Create 2020/12/12 22:33
 * @Version sparkmall
 */
@Configuration
public class AppWebMvcConfig implements WebMvcConfigurer {

    @Resource
    SeckillLoginInterceptor seckillLoginInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(seckillLoginInterceptor).addPathPatterns("/seckill/run/**");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/item.html").setViewName("item");
        registry.addViewController("/queue.html").setViewName("queue");
    }
}
