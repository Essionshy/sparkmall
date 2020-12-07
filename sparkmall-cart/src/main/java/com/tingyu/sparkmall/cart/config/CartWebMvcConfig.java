package com.tingyu.sparkmall.cart.config;

import com.tingyu.sparkmall.cart.interceptor.CartInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 购物车WebMvc配置类，配置拦截器使其生效
 *
 * @Author essionshy
 * @Create 2020/12/7 22:04
 * @Version renren-fast
 */
@Configuration
public class CartWebMvcConfig implements WebMvcConfigurer {


    /**
     * 给web容器添加拦截器
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截所有请求
        registry.addInterceptor(new CartInterceptor()).addPathPatterns("/**");
    }
}
