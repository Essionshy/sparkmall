package com.tingyu.sparkmall.pay.feign.fallback;

import com.tingyu.sparkmall.commons.dto.order.OrderDTO;
import com.tingyu.sparkmall.pay.feign.OrderFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author essionshy
 * @Create 2020/12/1 23:33
 * @Version renren-fast
 */

@Service
@Slf4j
public class OrderFallbackServiceImpl implements OrderFeignService {

    @Override
    public OrderDTO getByOrderNo(String orderNo) {

        log.info("调用订单服务失败，请稍后再试....");

        return null;
    }

    @Override
    public boolean updateOrderStatus(String orderNo, int status) {

        log.info("调用订单服务失败，请稍后再试....");
        return false;
    }
}
