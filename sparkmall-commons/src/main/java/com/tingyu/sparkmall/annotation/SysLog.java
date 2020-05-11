package com.tingyu.sparkmall.annotation;

import java.lang.annotation.*;

/**
 * @Author essionshy
 * @Create 2020/5/10 13:46
 * @Version sparkmall
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface SysLog {
}
