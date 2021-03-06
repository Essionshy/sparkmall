package com.tingyu.sparkmall.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

/**
 * @Author essionshy
 * @Create 2020/4/21 23:26
 * @Version sparkmall
 */
@Configuration

public class CorsConfig {

    @Bean
    public CorsWebFilter corsWebFilter() {


        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        CorsConfiguration config = new CorsConfiguration();
        //配置跨域
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        config.addAllowedOrigin("*");
        config.setAllowCredentials(true);

        source.registerCorsConfiguration("/**", config);

        return new CorsWebFilter(source);
    }

}
