package com.tingyu.sparkmall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableFeignClients(basePackages = {"com.tingyu.sparkmall.feign"})
@EnableAsync
@EnableScheduling
@MapperScan(basePackages = {"com.tingyu.sparkmall.dao"})
@SpringBootApplication
public class SparkmallLotteryApplication {

    public static void main(String[] args) {
        SpringApplication.run(SparkmallLotteryApplication.class, args);
    }

}
