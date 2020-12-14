package com.tingyu.sparkmall.seckill.interceptor;

import com.tingyu.sparkmall.commons.constant.AuthServerConstant;
import com.tingyu.sparkmall.commons.dto.MemberDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author essionshy
 * @Create 2020/12/12 17:51
 * @Version sparkmall
 */
@Component
public class SeckillLoginInterceptor implements HandlerInterceptor {

    public static ThreadLocal<MemberDTO> threadLocal = new ThreadLocal<>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //请求进来以后验证，该请求是否合法，


        MemberDTO loginUser = (MemberDTO) request.getSession().getAttribute(AuthServerConstant.LOGINED_USER_INFO);

        if (loginUser == null) {

            //用户没有登录，重定向到登录页面
            request.getSession().setAttribute("msg","抱歉，你还没有登录，无法参与秒杀活动，请立即登录");
            response.sendRedirect("http://auth.sparkmall.com/login.html");
            return false;
        }

        threadLocal.set(loginUser);
        //验证通过后，将用户信息保存到本地线程中


        return true;
    }


}
