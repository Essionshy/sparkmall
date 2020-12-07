package com.tingyu.sparkmall.pay.feign;

import com.tingyu.sparkmall.commons.dto.OrderDTO;
import com.tingyu.sparkmall.pay.feign.fallback.PayFeignFallbackServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Author essionshy
 * @Create 2020/12/2 20:40
 * @Version renren-fast
 */

@Component
@FeignClient(value = "sparkmall-thirdparty", fallback = PayFeignFallbackServiceImpl.class)
public interface PayFeignService {

    @PostMapping("alipay/pay")
    String pay(@RequestBody OrderDTO order);
}
