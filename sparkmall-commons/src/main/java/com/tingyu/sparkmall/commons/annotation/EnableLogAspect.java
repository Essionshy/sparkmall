package com.tingyu.sparkmall.commons.annotation;

import com.tingyu.sparkmall.commons.support.LogAspectBeanDefinitionRegistar;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @Author essionshy
 * @Create 2020/12/6 10:21
 * @Version renren-fast
 */


@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@Import({LogAspectBeanDefinitionRegistar.class})
public @interface EnableLogAspect {
}
