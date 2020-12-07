package com.tingyu.sparkmall.thirdparty.service;

import com.tingyu.sparkmall.commons.dto.OrderDTO;

/**
 * @Author essionshy
 * @Create 2020/12/2 19:47
 * @Version renren-fast
 */
public interface AlipayService {
    String pay(OrderDTO order);

}
