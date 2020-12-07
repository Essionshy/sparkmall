package com.tingyu.sparkmall.coupon.utils;

import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

/**
 * @Author essionshy
 * @Create 2020/12/5 16:38
 * @Version renren-fast
 */
@Component
public class PropertySourceUtil implements EmbeddedValueResolverAware {


    public static StringValueResolver resolver;

    @Override
    public void setEmbeddedValueResolver(StringValueResolver stringValueResolver) {
        this.resolver = stringValueResolver;
    }


}
