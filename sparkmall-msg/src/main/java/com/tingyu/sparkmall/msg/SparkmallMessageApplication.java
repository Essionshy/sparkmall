package com.tingyu.sparkmall.msg;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author essionshy
 * @Create 2020/12/3 13:03
 * @Version renren-fast
 */

@SpringBootApplication(exclude = {DruidDataSourceAutoConfigure.class,
        DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
@EnableFeignClients
public class SparkmallMessageApplication {
    public static void main(String[] args) {
        SpringApplication.run(SparkmallMessageApplication.class, args);
    }
}
