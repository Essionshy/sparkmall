package com.tingyu.sparkmall.search;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 检索服务
 * @Author essionshy
 * @Create 2020/12/6 16:50
 * @Version renren-fast
 */
@EnableDiscoveryClient
@EnableTransactionManagement
@SpringBootApplication(exclude = {DruidDataSourceAutoConfigure.class, DataSourceAutoConfiguration.class})
public class SparkmallSearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(SparkmallSearchApplication.class, args);
    }
}
