package com.tingyu.sparkmall.coupon.bean;

import com.tingyu.sparkmall.coupon.aspect.LogAspect;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Author essionshy
 * @Create 2020/12/5 17:31
 * @Version renren-fast
 */
public class CustomImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

        RootBeanDefinition beanDefinition = new RootBeanDefinition(LogAspect.class);

        registry.registerBeanDefinition("logAspectBean", beanDefinition);

    }
}
