package com.tingyu.sparkmall.commons.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Author essionshy
 * @Create 2020/4/7 13:44
 * @Version crm
 */
public abstract class ServletUtils {

    private ServletUtils() {
    }

    /**
     * 获取当前请求对象
     *
     * @return 请求对象
     */
    public static HttpServletRequest getHttpServletRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    /**
     * 获取响应对象
     *
     * @return
     */
    public static HttpServletResponse getHttpServletResponse() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
    }

    /**
     * 获取会话对象
     *
     * @return
     */
    public static HttpSession getHttpSession() {
        return getHttpServletRequest().getSession();
    }

    public static ServletContext getServletContext() {
        return getHttpServletRequest().getServletContext();
    }

    /**
     * 获取Session域中某个名称为param的对象
     *
     * @param param
     * @return
     */
    public static Object getObject(String param) {
        return getHttpServletRequest().getSession().getAttribute(param);
    }

}
