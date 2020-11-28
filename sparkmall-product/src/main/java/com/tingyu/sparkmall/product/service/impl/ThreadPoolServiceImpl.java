package com.tingyu.sparkmall.product.service.impl;

import com.tingyu.sparkmall.product.service.ThreadPoolService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author essionshy
 * @Create 2020/6/7 16:54
 * @Version renren-fast
 */
@Service
public class ThreadPoolServiceImpl implements ThreadPoolService {

    @Qualifier("mainThreadPoolExecutor")
    @Resource
    ThreadPoolExecutor mainThreadPoolExecutor;

    @Qualifier("otherThreadPoolExecutor")
    @Resource
    ThreadPoolExecutor otherThreadPoolExecutor;

    @Resource
    ApplicationContext context;

    @Override
    public void start() {
        boolean isShutdown = otherThreadPoolExecutor.isShutdown();
        if(isShutdown){
            System.out.println("线程池关闭，拒绝连接");

            ThreadPoolExecutor bean = context.getBean("otherThreadPoolExecutor",ThreadPoolExecutor.class);
            System.out.println(bean.isTerminating());
            System.out.println(bean.isTerminated());

            bean.execute(()->{
                System.out.print("this thread pool is closed");
            });
            System.out.println();
        }else{
            System.out.println("线程池状态正常");

           // otherThreadPoolExecutor.purge();
        }
    }

    @Override
    public void shutdown() {
        otherThreadPoolExecutor.shutdown();
    }

    @Override
    public Map<String, Object> getStatus() {

        Map<String,Object> status= new HashMap<>();
        status.put("activeCount",otherThreadPoolExecutor.getActiveCount());
        status.put("corePoolSize",otherThreadPoolExecutor.getCorePoolSize());
        status.put("maximumPoolSize",otherThreadPoolExecutor.getMaximumPoolSize());
        status.put("taskCount",otherThreadPoolExecutor.getTaskCount());
        status.put("completedTaskCount",otherThreadPoolExecutor.getCompletedTaskCount());
        status.put("workQueueSize",otherThreadPoolExecutor.getQueue().remainingCapacity());

        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        Arrays.asList(beanDefinitionNames).forEach(System.out::println);
        return status;
    }
}
