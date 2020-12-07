package com.tingyu.sparkmall.cart.feign.fallback;

import com.tingyu.sparkmall.cart.feign.ProductFeignService;
import com.tingyu.sparkmall.commons.dto.ProductDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author essionshy
 * @Create 2020/12/2 15:51
 * @Version renren-fast
 */
@Service
@Slf4j
public class ProductFeignFallbackServiceImpl implements ProductFeignService {
    @Override
    public List<ProductDTO> listByProducts(List<String> products) {
        log.info("调用商品服务失败，请稍后再试...");
        return null;
    }
}
