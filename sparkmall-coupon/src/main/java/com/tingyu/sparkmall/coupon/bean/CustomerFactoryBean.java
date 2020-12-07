package com.tingyu.sparkmall.coupon.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @Author essionshy
 * @Create 2020/12/5 16:18
 * @Version renren-fast
 */
public class CustomerFactoryBean implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        return null;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
