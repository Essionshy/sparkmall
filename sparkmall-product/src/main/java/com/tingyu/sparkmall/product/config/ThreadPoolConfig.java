package com.tingyu.sparkmall.product.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author essionshy
 * @Create 2020/6/7 16:38
 * @Version renren-fast
 */
@Configuration
public class ThreadPoolConfig {

    @Bean(value = "mainThreadPoolExecutor")
    public ThreadPoolExecutor mainThreadPoolExecutor(ThreadPoolProperties threadPoolProperties){

        LinkedBlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>(threadPoolProperties.getWorkQueueSize());
        ThreadPoolExecutor mainThreadPoolExecutor = new ThreadPoolExecutor(threadPoolProperties.getCorePoolSize(),
                                    threadPoolProperties.getMaxPoolSize(),10,
                                    TimeUnit.MINUTES,workQueue,
                                    Executors.defaultThreadFactory(),
                                    new ThreadPoolExecutor.AbortPolicy());
        return mainThreadPoolExecutor;
    }


    @Bean(value = "otherThreadPoolExecutor")
    public ThreadPoolExecutor otherThreadPoolExecutor(ThreadPoolProperties threadPoolProperties){

        LinkedBlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>(threadPoolProperties.getWorkQueueSize());
        ThreadPoolExecutor mainThreadPoolExecutor = new ThreadPoolExecutor(threadPoolProperties.getCorePoolSize(),
                threadPoolProperties.getMaxPoolSize(),
                10,
                TimeUnit.MINUTES,workQueue,
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        return mainThreadPoolExecutor;
    }
}
