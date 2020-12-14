package com.tingyu.sparkmall.order;

import com.tingyu.sparkmall.order.config.DataSourceProxyAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@EnableFeignClients("com.tingyu.sparkmall.order.feign")
@EnableDiscoveryClient
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@Import(value = {DataSourceProxyAutoConfiguration.class})
public class SparkmallOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SparkmallOrderApplication.class, args);
    }

}
