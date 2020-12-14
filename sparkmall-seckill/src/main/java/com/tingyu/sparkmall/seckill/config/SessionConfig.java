package com.tingyu.sparkmall.seckill.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.session.web.http.CookieSerializer;
import org.springframework.session.web.http.DefaultCookieSerializer;

/**
 * @Author essionshy
 * @Create 2020/12/8 20:18
 * @Version renren-fast
 */
@Configuration
public class SessionConfig {

    /**
     * 修改 spring-session 默认的序列化器
     * @return
     */
    @Bean
    public RedisSerializer<Object> springSessionDefaultRedisSerializer() {
        return new GenericJackson2JsonRedisSerializer();
    }

    /**
     * 修改 spring-session 默认的 cookie序列化器
     * @return
     */
    @Bean
    public CookieSerializer cookieSerializer() {
        DefaultCookieSerializer serializer = new DefaultCookieSerializer();
        serializer.setCookieName("SPARKMALLSESSION");
        serializer.setDomainName("sparkmall.com"); //将作用域提高到父级，扩大范围
        return serializer;
    }

}
