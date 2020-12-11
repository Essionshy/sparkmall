package com.tingyu.sparkmall.auth;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @Author essionshy
 * @Create 2020/12/7 22:32
 * @Version renren-fast
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, DruidDataSourceAutoConfigure.class})
@EnableDiscoveryClient
@EnableFeignClients
@EnableRedisHttpSession
public class SparkmallAuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(SparkmallAuthApplication.class,args);
    }
}
