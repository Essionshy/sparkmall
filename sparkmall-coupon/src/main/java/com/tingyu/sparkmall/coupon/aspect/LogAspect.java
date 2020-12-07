package com.tingyu.sparkmall.coupon.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @Author essionshy
 * @Create 2020/12/5 20:34
 * @Version renren-fast
 */

@Aspect
@Slf4j
public class LogAspect {


    @Pointcut(value = "execution(public boolean com.tingyu.sparkmall.coupon.service.impl.CouponServiceImpl.*(..))")
    public void logAspect() {

    }

    @Before("logAspect()")
    public void logStart(JoinPoint joinPoint) {
        log.info("执行方法的前置通知：{}", joinPoint.getSignature().getName());
    }

    @After("logAspect()")
    public void logAfter(JoinPoint joinPoint) {
        log.info("执行方法的后置通知：{}", joinPoint.getSignature().getName());
    }

    @AfterReturning(value = "logAspect()", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        log.info("执行方法的返回通知方法：{}，返回结果：{}", joinPoint.getSignature().getName(), result);
    }

    @AfterThrowing(value = "logAspect()", throwing = "ex")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable ex) {
        log.info("执行方法的异常通知：{}，异常信息：{}", joinPoint.getSignature().getName(), ex);
    }

}
