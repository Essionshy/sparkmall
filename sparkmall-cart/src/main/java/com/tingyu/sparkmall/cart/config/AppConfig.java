package com.tingyu.sparkmall.cart.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author essionshy
 * @Create 2020/12/2 12:39
 * @Version renren-fast
 */
@Configuration
@MapperScan("com.tingyu.sparkmall.cart.mapper")
@ComponentScan("com.tingyu.sparkmall")
public class AppConfig {


}
