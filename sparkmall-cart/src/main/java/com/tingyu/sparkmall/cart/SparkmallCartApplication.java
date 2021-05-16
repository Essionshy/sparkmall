package com.tingyu.sparkmall.cart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author essionshy
 * @Create 2020/12/2 0:00
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class SparkmallCartApplication {
    public static void main(String[] args) {
        SpringApplication.run(SparkmallCartApplication.class, args);
    }
}
