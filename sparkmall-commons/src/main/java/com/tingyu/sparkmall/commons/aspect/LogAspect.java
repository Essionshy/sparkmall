package com.tingyu.sparkmall.commons.aspect;

import com.google.gson.Gson;
import com.tingyu.sparkmall.commons.annotation.Operation;
import com.tingyu.sparkmall.commons.annotation.SysLog;
import com.tingyu.sparkmall.commons.utils.ServletUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 *
 */
@Order(value = 3)
@Aspect
@Slf4j
public class LogAspect {

    private Lock lock = new ReentrantLock();

    // @Pointcut("execution(* com.tingyu.crm.controller.*(..))")
    @Pointcut("@annotation(com.tingyu.sparkmall.commons.annotation.SysLog)")
    //@Pointcut("@annotation(io.swagger.annotations.ApiOperation)")
    public void logAspect() {
    }

    @Around("logAspect()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result = null;
        log.info("==================请求开始===================");

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

        log.info("请求链接：{}", request.getRequestURL().toString());
        log.info("请求SessionID:{}", ServletUtils.getHttpSession().getId());
        log.info("接口描述信息：{}", operationName);
        log.info("请求类型:{}", request.getMethod());
        log.info("请求方法:{}.{}", signature.getDeclaringTypeName(), signature.getName());
        log.info("请求IP:{}", request.getRemoteAddr());
        log.info("请求入参：{}", new Gson().toJson(joinPoint.getArgs()));


        //获取目标方法是否被 @SysLog注解标注，如果有则需要保存进入数据库中，如果没有仅在控制台打印和输出到日志文件
        SysLog annotation = method.getAnnotation(SysLog.class);

        //TODO 保存操作日志

        try {
            result = joinPoint.proceed();
        } catch (Exception e) {
            throw e;
        } finally {
            long endTime = System.currentTimeMillis();
            log.info("请求入参：[{}]ms", (endTime - startTime));
        }
        return result;
    }

}
