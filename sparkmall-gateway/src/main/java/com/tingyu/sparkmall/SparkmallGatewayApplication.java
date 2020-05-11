package com.tingyu.sparkmall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SparkmallGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(SparkmallGatewayApplication.class, args);
    }

}
