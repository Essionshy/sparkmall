package com.tingyu.sparkmall.pay;

import com.tingyu.sparkmall.pay.config.DataSourceProxyAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;

/**
 * @Author essionshy
 * @Create 2020/12/1 23:04
 * @Version renren-fast
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
@EnableFeignClients
@Import(value = {DataSourceProxyAutoConfiguration.class})
public class SparkmallPayApplication {

    public static void main(String[] args) {
        SpringApplication.run(SparkmallPayApplication.class, args);
    }

}
