package com.tingyu.sparkmall.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients("com.tingyu.sparkmall.order.feign")
@EnableDiscoveryClient
@SpringBootApplication
public class SparkmallOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SparkmallOrderApplication.class, args);
    }

}
