package com.tingyu.sparkmall.lottery.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author essionshy
 * @Create 2020/11/27 18:36
 * @Version renren-fast
 */

@EnableHystrix
@Configuration
@MapperScan("com.tingyu.sparkmall.lottery.dao")
@ComponentScan(value = "com.tingyu.sparkmall")
public class ApplicationConfig {


}
