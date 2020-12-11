package com.tingyu.sparkmall.member.config;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author essionshy
 * @Create 2020/11/29 13:28
 * @Version renren-fast
 */
@Configuration
@MapperScan(value = "com.tingyu.sparkmall.member.dao")
@ComponentScan(value = "com.tingyu.sparkmall")
public class AppConfig {


    /**
     * 配置 HystrixMetricsStreamServlet ，否则 HystrixDashboard 无法获取到该应用数据
     *
     * @return
     */
    @Bean
    public ServletRegistrationBean<HystrixMetricsStreamServlet> getServlet() {
        ServletRegistrationBean<HystrixMetricsStreamServlet> servletRegistrationBean = new ServletRegistrationBean<>();
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        servletRegistrationBean.setServlet(streamServlet);
        servletRegistrationBean.setLoadOnStartup(1); //应用启动时启用
        servletRegistrationBean.setName("HystrixMetricsStreamServlet");
        servletRegistrationBean.addUrlMappings("/hystrix.stream");
        return servletRegistrationBean;
    }

}
