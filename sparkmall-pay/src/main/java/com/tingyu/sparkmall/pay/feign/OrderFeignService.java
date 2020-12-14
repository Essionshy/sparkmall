package com.tingyu.sparkmall.pay.feign;

import com.tingyu.sparkmall.commons.dto.order.OrderDTO;
import com.tingyu.sparkmall.pay.feign.fallback.OrderFallbackServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author essionshy
 * @Create 2020/12/1 23:17
 * @Version renren-fast
 */
@Component
@FeignClient(value = "sparkmall-order", fallback = OrderFallbackServiceImpl.class)
public interface OrderFeignService {


    @GetMapping("order/get/{orderNo}")
    OrderDTO getByOrderNo(@PathVariable("orderNo") String orderNo);

    @GetMapping("order/update/status/{orderNo}/{status}")
    boolean updateOrderStatus(@PathVariable("orderNo") String orderNo, @PathVariable("status") int status);
}
