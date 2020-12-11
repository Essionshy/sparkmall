package com.tingyu.sparkmall.seckill.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * @Author essionshy
 * @Create 2020/6/5 16:43
 * @Version renren-fast
 */
@Configuration
public class RedissonConfig {

    @Value("${redisson.single.node}")
    private String address;

    @Bean(destroyMethod = "shutdown")
    public RedissonClient redisson() throws IOException {
        //1、配置单节点服务
        Config config = new Config();
        config.useSingleServer().setAddress(address);
        RedissonClient redisson = Redisson.create(config);
        return redisson;
    }
}
