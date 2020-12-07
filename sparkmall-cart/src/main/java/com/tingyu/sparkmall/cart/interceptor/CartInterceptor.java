package com.tingyu.sparkmall.cart.interceptor;

import com.tingyu.sparkmall.commons.constant.AuthServerConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 购物车服务拦截器，判断用户登录状态
 *
 * @Author essionshy
 * @Create 2020/12/7 21:55
 * @Version renren-fast
 */
@Slf4j
public class CartInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Object attribute = request.getSession().getAttribute(AuthServerConstant.LOGINED_USER_INFO);

        if (attribute == null) {
            //未登录


        } else {
            //已登录
        }


        //不管用户是否登录始终放行请求
        return true;
    }
}
