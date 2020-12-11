package com.tingyu.sparkmall.seckill.feign;

import com.tingyu.sparkmall.commons.dto.seckill.SeckillSessionDTO;
import com.tingyu.sparkmall.commons.support.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * 远程调用优惠系统服务
 * @Author essionshy
 * @Create 2020/12/11 14:58
 * @Version renren-fast
 */

@FeignClient("sparkmall-coupon")
public interface CouponFeignService {

    @GetMapping("/coupon/seckillsession/listLatest3DaysSessions")
    CommonResult<List<SeckillSessionDTO>> listLatest3DaysSessions();
}
