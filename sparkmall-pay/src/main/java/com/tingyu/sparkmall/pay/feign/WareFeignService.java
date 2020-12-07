package com.tingyu.sparkmall.pay.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author essionshy
 * @Create 2020/12/5 0:27
 * @Version renren-fast
 */
@Component
@FeignClient(value = "sparkmall-ware")
public interface WareFeignService {

    @GetMapping("/ware/deliver/{orderNo}")
    void deliver(@PathVariable("orderNo") String orderNo);

}
