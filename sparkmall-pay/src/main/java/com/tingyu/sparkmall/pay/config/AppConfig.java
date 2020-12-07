package com.tingyu.sparkmall.pay.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author essionshy
 * @Create 2020/11/28 22:23
 * @Version renren-fast
 */
@Configuration
@ComponentScan(value = "com.tingyu.sparkmall")
@MapperScan("com.tingyu.sparkmall.pay.mapper")
public class AppConfig {


}
