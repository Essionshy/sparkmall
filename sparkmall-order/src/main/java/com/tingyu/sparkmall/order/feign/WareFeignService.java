package com.tingyu.sparkmall.order.feign;

import com.tingyu.sparkmall.commons.dto.ProductDTO;
import com.tingyu.sparkmall.commons.dto.WareDTO;
import com.tingyu.sparkmall.order.feign.fallback.WareFeignFallbackServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author essionshy
 * @Create 2020/11/27 22:52
 * @Version renren-fast
 */
@FeignClient(name = "sparkmall-ware", fallback = WareFeignFallbackServiceImpl.class)
//@FeignClient(name = "sparkmall-ware")
@Component
public interface WareFeignService {

    @GetMapping("/ware/get/{productNo}")
    WareDTO get(@PathVariable("productNo") String productNo);

    @PutMapping("/ware/decreate/{productNo}/{count}")
    boolean decrease(@PathVariable("productNo") String productNo, @PathVariable("count") BigDecimal count);

    @PostMapping("/ware/decrease")
    boolean decrease(@RequestBody List<ProductDTO> products);
}
