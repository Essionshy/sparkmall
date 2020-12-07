package com.tingyu.sparkmall.cart.feign;

import com.tingyu.sparkmall.cart.feign.fallback.ProductFeignFallbackServiceImpl;
import com.tingyu.sparkmall.commons.dto.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @Author essionshy
 * @Create 2020/12/2 12:31
 * @Version renren-fast
 */
@FeignClient(value = "sparkmall-product", fallback = ProductFeignFallbackServiceImpl.class)
@Component
public interface ProductFeignService {

    @PostMapping("/product/item/fiegn/list")
    List<ProductDTO> listByProducts(@RequestBody List<String> products);
}
