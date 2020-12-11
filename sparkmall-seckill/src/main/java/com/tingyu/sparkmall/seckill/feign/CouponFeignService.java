package com.tingyu.sparkmall.seckill.feign;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * 远程调用优惠系统服务
 * @Author essionshy
 * @Create 2020/12/11 14:58
 * @Version renren-fast
 */

@FeignClient("sparkmall-coupon")
public interface CouponFeignService {


}
