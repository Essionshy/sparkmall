package com.tingyu.sparkmall.order.feign.fallback;

import com.tingyu.sparkmall.commons.dto.ProductDTO;
import com.tingyu.sparkmall.commons.dto.WareDTO;
import com.tingyu.sparkmall.order.feign.WareFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * 调用库存服务异常处理器
 *
 * @Author essionshy
 * @Create 2020/11/30 21:41
 * @Version renren-fast
 */
@Service
@Slf4j
public class WareFeignFallbackServiceImpl implements WareFeignService {
    @Override
    public WareDTO get(String productNo) {
        log.info("库存服务调用失败，请稍后再试...");
        WareDTO wareDTO = new WareDTO();
        return null;
    }

    @Override
    public boolean decrease(String productNo, BigDecimal count) {
        log.info("库存服务调用失败，请稍后再试...");
        throw new RuntimeException("jfsdfljl");
    }

    @Override
    public boolean decrease(List<ProductDTO> products) {

        log.info("批量扣减商品库存");
        return false;
    }
}
