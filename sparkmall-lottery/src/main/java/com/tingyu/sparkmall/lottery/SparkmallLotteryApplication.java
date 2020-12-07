package com.tingyu.sparkmall.lottery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableHystrix
@EnableFeignClients(basePackages = {"com.tingyu.sparkmall.lottery.feign"})
@EnableAsync
@EnableScheduling
@SpringBootApplication
public class SparkmallLotteryApplication {

    public static void main(String[] args) {
        SpringApplication.run(SparkmallLotteryApplication.class, args);
    }

}
