package com.tingyu.sparkmall.coupon;

import com.tingyu.sparkmall.coupon.config.AppConfig;
import com.tingyu.sparkmall.coupon.service.CouponService;
import com.tingyu.sparkmall.coupon.utils.PropertySourceUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest(classes = {SparkmallCouponApplication.class})
@ContextConfiguration(classes = {AppConfig.class})
class SparkmallCouponApplicationTests {


    @Autowired
    ApplicationContext ctx;

    @Autowired
    CouponService couponService;

    @Test
    void contextLoads() {
        System.out.println("this is a test ");


    }

    @Test
    void testStringValueResolver() {
        String value = PropertySourceUtil.resolver.resolveStringValue("#{20*15}");

        System.out.println(value);
    }



}
