package com.tingyu.sparkmall.pay.feign.fallback;

import com.tingyu.sparkmall.commons.dto.OrderDTO;
import com.tingyu.sparkmall.pay.feign.PayFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author essionshy
 * @Create 2020/12/2 20:42
 * @Version renren-fast
 */
@Service
@Slf4j
public class PayFeignFallbackServiceImpl implements PayFeignService {
    @Override
    public String pay(OrderDTO order) {
        log.info("调用支付服务失败，请求稍后再试...");

        return null;
    }
}
