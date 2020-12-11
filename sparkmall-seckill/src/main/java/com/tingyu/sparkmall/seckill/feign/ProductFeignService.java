package com.tingyu.sparkmall.seckill.feign;

import com.tingyu.sparkmall.commons.dto.product.SkuInfoDTO;
import com.tingyu.sparkmall.commons.support.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author essionshy
 * @Create 2020/12/11 22:34
 * @Version sparkmall
 */

@FeignClient(value = "sparkmall-product")
public interface ProductFeignService {
    @GetMapping("/product/sku/getSkuInfoById/{skuId}")
    CommonResult<SkuInfoDTO> getSkuInfoById(@PathVariable("skuId") Long skuId);

}
