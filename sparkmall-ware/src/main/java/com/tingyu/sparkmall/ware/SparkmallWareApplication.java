package com.tingyu.sparkmall.ware;

import com.tingyu.sparkmall.ware.config.DataSourceProxyAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@Import(value = {DataSourceProxyAutoConfiguration.class})
public class SparkmallWareApplication {
    public static void main(String[] args) {
        SpringApplication.run(SparkmallWareApplication.class, args);
    }


}
