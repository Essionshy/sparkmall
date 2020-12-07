package com.tingyu.sparkmall.commons.annotation;

import java.lang.annotation.*;

/**
 * @Author essionshy
 * @Create 2020/5/10 13:51
 * @Version sparkmall
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Operation {

    String value() default "";
}
