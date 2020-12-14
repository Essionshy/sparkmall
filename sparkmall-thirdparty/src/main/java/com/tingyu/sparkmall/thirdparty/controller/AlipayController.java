package com.tingyu.sparkmall.thirdparty.controller;

import com.tingyu.sparkmall.commons.dto.order.OrderDTO;
import com.tingyu.sparkmall.thirdparty.service.AlipayService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author essionshy
 * @Create 2020/12/2 19:46
 * @Version renren-fast
 */
@RequestMapping("alipay")
@RestController
public class AlipayController {

    @Resource
    private AlipayService alipayService;

    @PostMapping("pay")
    public String pay(@RequestBody OrderDTO order) {
        return alipayService.pay(order);
    }


}
