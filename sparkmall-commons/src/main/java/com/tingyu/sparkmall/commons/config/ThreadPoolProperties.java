package com.tingyu.sparkmall.commons.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Author essionshy
 * @Create 2020/6/7 16:43
 * @Version renren-fast
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "sparkmall.pool")
public class ThreadPoolProperties {

    private Integer corePoolSize;

    private Integer maxPoolSize;

    private Integer workQueueSize;

}
