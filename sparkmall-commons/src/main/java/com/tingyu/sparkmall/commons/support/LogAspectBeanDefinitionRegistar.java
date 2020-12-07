package com.tingyu.sparkmall.commons.support;

import com.tingyu.sparkmall.commons.aspect.LogAspect;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Author essionshy
 * @Create 2020/12/6 10:23
 * @Version renren-fast
 */

public class LogAspectBeanDefinitionRegistar implements ImportBeanDefinitionRegistrar {


    private static final String LOG_ASPECT_NAME = "com.tingyu.sparkmall.commons.aspect.LogAspect";


    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {


        RootBeanDefinition beanDefinition = new RootBeanDefinition(LogAspect.class);

        registry.registerBeanDefinition(LOG_ASPECT_NAME, beanDefinition);

    }


}
