package com.tingyu.sparkmall.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableCircuitBreaker //开启熔断器
@SpringBootApplication
@EnableDiscoveryClient
public class SparkmallMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(SparkmallMemberApplication.class, args);

    }


}
