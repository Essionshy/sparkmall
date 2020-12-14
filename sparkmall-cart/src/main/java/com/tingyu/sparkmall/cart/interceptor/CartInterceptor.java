package com.tingyu.sparkmall.cart.interceptor;

import com.tingyu.sparkmall.commons.constant.AuthServerConstant;
import com.tingyu.sparkmall.commons.constant.CartServerConstant;
import com.tingyu.sparkmall.commons.dto.MemberDTO;
import com.tingyu.sparkmall.commons.dto.UserInfoDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * 购物车服务拦截器，判断用户登录状态
 *
 * @Author essionshy
 * @Create 2020/12/7 21:55
 * @Version renren-fast
 */
@Slf4j
public class CartInterceptor implements HandlerInterceptor {

    public static ThreadLocal<UserInfoDTO> threadLocal = new ThreadLocal<>();

    /**
     * 验证用户是否登录，并保存用户信息到本地线程中
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //获取登录会员信息
        MemberDTO member = (MemberDTO) request.getSession().getAttribute(AuthServerConstant.LOGINED_USER_INFO);

        UserInfoDTO user = new UserInfoDTO();

        if (member == null) {
            //如果用户未登录，则由系统生成一个临时userKey,请求结束后将其返回给客户端，并保存在 cookie中，下次请求携带上该数据

            String tempUserKey = tryGetUserKeyFromCookie(request);
            if (tempUserKey == null) {
                tempUserKey = UUID.randomUUID().toString();

            }else{
                user.setHasTempUserKey(true);
            }
            user.setUserKey(tempUserKey);

        } else {
            //已登录
            user.setUserId(member.getUserId().toString());
        }

        //将用户信息保存到线程本地共享
        threadLocal.set(user);

        //不管用户是否登录始终放行请求
        return true;
    }

    /**
     * 尝试获取临时用户
     *
     * @param request
     */
    private String tryGetUserKeyFromCookie(HttpServletRequest request) {

        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equalsIgnoreCase(CartServerConstant.TEMP_USER_KEY_NAME)) {
                    return cookie.getValue();
                }

            }
        }

        return null;

    }


    /**
     * 将生成的临时用户信息保存到 cookie中
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        //判断用户是否已经拥有临时用户key
        UserInfoDTO userInfoDTO = threadLocal.get();
        if (userInfoDTO.getHasTempUserKey()) {
            return;
        }

        String tempUserKey = userInfoDTO.getUserKey();
        Cookie cookie = new Cookie(CartServerConstant.TEMP_USER_KEY_NAME, tempUserKey);
        cookie.setDomain("sparkmall.com");
        cookie.setMaxAge(CartServerConstant.TEMP_USER_KEY_EXPIRE);
        response.addCookie(cookie);
    }
}
