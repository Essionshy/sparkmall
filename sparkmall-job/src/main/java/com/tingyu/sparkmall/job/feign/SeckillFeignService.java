package com.tingyu.sparkmall.job.feign;

import com.tingyu.sparkmall.commons.support.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author essionshy
 * @Create 2020/12/11 14:45
 * @Version renren-fast
 */
@FeignClient("sparkmall-seckill")
public interface SeckillFeignService {


    @GetMapping("/seckill/up")
     CommonResult up();
}
