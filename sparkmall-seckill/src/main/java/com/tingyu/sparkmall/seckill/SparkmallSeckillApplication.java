package com.tingyu.sparkmall.seckill;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 秒杀系统
 */
@EnableDiscoveryClient
@SpringBootApplication(exclude = {DruidDataSourceAutoConfigure.class})
public class SparkmallSeckillApplication {

    public static void main(String[] args) {
        SpringApplication.run(SparkmallSeckillApplication.class, args);
    }

}
