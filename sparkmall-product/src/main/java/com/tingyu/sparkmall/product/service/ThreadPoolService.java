package com.tingyu.sparkmall.product.service;

import java.util.Map;

/**
 * @Author essionshy
 * @Create 2020/6/7 16:52
 * @Version renren-fast
 */
public interface ThreadPoolService {

    public void start();

    public void shutdown();

    public Map<String,Object> getStatus();
}
