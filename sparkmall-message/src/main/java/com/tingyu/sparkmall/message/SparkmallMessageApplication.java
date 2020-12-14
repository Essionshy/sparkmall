package com.tingyu.sparkmall.message;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author essionshy
 * @Create 2020/12/3 13:03
 * @Version renren-fast
 */
@EnableRabbit
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class SparkmallMessageApplication {
    public static void main(String[] args) {
        SpringApplication.run(SparkmallMessageApplication.class, args);
    }
}
