package com.tingyu.sparkmall.coupon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @Author essionshy
 * @Create 2020/12/5 16:14
 * @Version renren-fast
 */
@Configuration
@ComponentScan("com.tingyu.sparkmall")
@EnableTransactionManagement
public class AppConfig {


    /**
     * 配置事务管理器
     *
     * @param dataSource 数据源，以便事务管理器对数据库操作
     * @return
     */
    @Bean
    public PlatformTransactionManager dataSourceTransactionManager(DataSource dataSource) {

        return new DataSourceTransactionManager(dataSource);
    }


}
