package com.tingyu.sparkmall.message.feign;

import com.tingyu.sparkmall.commons.dto.order.OrderDTO;
import com.tingyu.sparkmall.commons.support.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
    @GetMapping("/order/close/{orderNo}")
    boolean closeOrder(@PathVariable("orderNo")String orderNo);

    @PostMapping("/order/create")
    CommonResult createOrder(@RequestBody OrderDTO order);
}
