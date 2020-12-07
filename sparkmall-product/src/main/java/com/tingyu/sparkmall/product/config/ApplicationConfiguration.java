package com.tingyu.sparkmall.product.config;

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
@MapperScan("com.tingyu.sparkmall.product.mapper")

public class ApplicationConfiguration {


}
