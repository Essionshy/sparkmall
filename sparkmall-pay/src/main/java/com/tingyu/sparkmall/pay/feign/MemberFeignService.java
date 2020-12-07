package com.tingyu.sparkmall.pay.feign;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @Author essionshy
 * @Create 2020/12/1 23:17
 * @Version renren-fast
 */
@FeignClient("sparkmall-member")
public interface MemberFeignService {
}
