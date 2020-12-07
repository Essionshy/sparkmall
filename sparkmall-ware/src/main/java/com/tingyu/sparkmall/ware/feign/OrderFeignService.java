package com.tingyu.sparkmall.ware.feign;

import com.tingyu.sparkmall.commons.dto.OrderDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author essionshy
 * @Create 2020/12/5 0:33
 * @Version renren-fast
 */
@Component
@FeignClient(value = "sparkmall-order")
public interface OrderFeignService {

    @GetMapping("order/get/{orderNo}")
    OrderDTO getByOrderNo(@PathVariable("orderNo") String orderNo);

}
