package com.tingyu.sparkmall.coupon;

import com.tingyu.sparkmall.commons.annotation.EnableLogAspect;
import com.tingyu.sparkmall.coupon.bean.CustomImportBeanDefinitionRegistrar;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

/**
 * @Author essionshy
 * @Create 2020/12/5 11:55
 * @Version renren-fast
 */
@EnableLogAspect
@SpringBootApplication
@EnableDiscoveryClient
@Import({CustomImportBeanDefinitionRegistrar.class})
public class SparkmallCouponApplication {

    public static void main(String[] args) {
        SpringApplication.run(SparkmallCouponApplication.class, args);
    }
}
