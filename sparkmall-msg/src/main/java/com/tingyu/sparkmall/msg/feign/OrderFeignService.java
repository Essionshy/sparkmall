package com.tingyu.sparkmall.msg.feign;

import com.tingyu.sparkmall.commons.dto.OrderDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author essionshy
 * @Create 2020/12/11 11:55
 * @Version renren-fast
 */

@FeignClient("sparkmall-order")
public interface OrderFeignService {

    @GetMapping("/order/get/{orderNo}")
    OrderDTO getByOrderNo(@PathVariable("orderNo") String orderNo);

    @GetMapping("/order/update/status/{orderNo}/{status}")
    boolean updateOrderStatus(@PathVariable("orderNo") String orderNo, @PathVariable("status") int status);
    @GetMapping("/close/{orderNo}")
    boolean closeOrder(@PathVariable("orderNo")String orderNo);
}
