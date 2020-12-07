package com.tingyu.sparkmall.job;

import com.tingyu.sparkmall.commons.annotation.EnableLogAspect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author essionshy
 * @Create 2020/12/5 10:19
 * @Version renren-fast
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableLogAspect
public class SparkmallJobApplication {

    public static void main(String[] args) {
        SpringApplication.run(SparkmallJobApplication.class, args);
    }
}
