package com.tingyu.sparkmall.aspect;

import com.google.gson.Gson;
import com.tingyu.sparkmall.annotation.Operation;
import com.tingyu.sparkmall.annotation.SysLog;
import com.tingyu.sparkmall.utils.ServletUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 *
 */
@Order(value = 3)
@Component
@Aspect
public class LogAspect {

    private Logger logger = LoggerFactory.getLogger(LogAspect.class);
    private Lock lock = new ReentrantLock();

    // @Pointcut("execution(* com.tingyu.crm.controller.*(..))")
    @Pointcut("@annotation(com.tingyu.sparkmall.annotation.SysLog)")
    public void logAspect() {
    }

    @Around("logAspect()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result = null;
        logger.debug("==================请求开始===================");

        long startTime = System.currentTimeMillis();
        //获取请求对象
        HttpServletRequest request = ServletUtils.getHttpServletRequest();
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        //获取接口描述信息
        Operation operation = method.getAnnotation(Operation.class);
        String operationName = "";
        if (operation != null) {
            operationName = operation.value();
        }

        logger.debug("请求链接：{}", request.getRequestURL().toString());
        logger.debug("请求SessionID:{}", ServletUtils.getHttpSession().getId());
        logger.debug("接口描述信息：{}", operationName);
        logger.debug("请求类型:{}", request.getMethod());
        logger.debug("请求方法:{}.{}", signature.getDeclaringTypeName(), signature.getName());
        logger.debug("请求IP:{}", request.getRemoteAddr());
        logger.debug("请求入参：{}", new Gson().toJson(joinPoint.getArgs()));


        //获取目标方法是否被 @SysLog注解标注，如果有则需要保存进入数据库中，如果没有仅在控制台打印和输出到日志文件
        SysLog annotation = method.getAnnotation(SysLog.class);

        try {
            result = joinPoint.proceed();
        } catch (Exception e) {
            throw e;
        } finally {
            long endTime = System.currentTimeMillis();
            logger.debug("请求入参：[{}]ms", (endTime - startTime));
        }
        return result;
    }

}
