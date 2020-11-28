package com.tingyu.sparkmall.order.feign;

import com.tingyu.sparkmall.dto.WareDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.math.BigDecimal;

/**
 * @Author essionshy
 * @Create 2020/11/27 22:52
 * @Version renren-fast
 */
@FeignClient("sparkmall-ware")
@Component
public interface WareFeignService {

    @GetMapping("/api/ware/get/{productNo}")
    WareDTO get(@PathVariable("productNo") String productNo);

    @PutMapping("/api/ware/decreate/{productNo}/{count}")
    boolean decreate(@PathVariable("productNo") String productNo, @PathVariable("count") BigDecimal count);
}
