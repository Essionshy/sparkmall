package com.tingyu.sparkmall.thirdparty.service.impl;

import com.tingyu.sparkmall.commons.dto.order.OrderDTO;
import com.tingyu.sparkmall.thirdparty.properties.AlipayProperties;
import com.tingyu.sparkmall.thirdparty.service.AlipayService;
import com.tingyu.sparkmall.thirdparty.utils.AlipayUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author essionshy
 * @Create 2020/12/2 19:48
 * @Version renren-fast
 */
@Service
@Slf4j
public class AlipayServiceImpl implements AlipayService {


    @Override
    public String pay(OrderDTO order) {

        Map<String, Object> bizContent = new HashMap<>();

        bizContent.put(AlipayUtil.OUT_TRADE_NO, order.getOrderNo()); //订单号
        bizContent.put(AlipayUtil.PRODUCT_CODE, AlipayProperties.PRODUCT_NO); //沙箱商户号
        bizContent.put(AlipayUtil.SUBJECT, "订单支付");// TODO 设置标题
        bizContent.put(AlipayUtil.TOTAL_AMOUNT, order.getTotalFee());

        return AlipayUtil.pay(bizContent);

    }
}
