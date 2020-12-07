package com.tingyu.sparkmall.pay.controller;

import com.tingyu.sparkmall.commons.utils.R;
import com.tingyu.sparkmall.pay.service.PayService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author essionshy
 * @Create 2020/12/1 23:05
 * @Version renren-fast
 */
@RefreshScope //nacos 配置修改后实时刷新
@RestController
@RequestMapping("pay")
@Slf4j
public class PayController {


    @Resource
    private PayService payService;

    @ApiOperation("支付")
    @GetMapping("/{orderNo}/{payType}")
    public String pay(@PathVariable("orderNo") String orderNo, @PathVariable("payType") Integer payType) {

        String from = payService.pay(orderNo, payType);

        log.info("支付完成，返回支付页面 form 表单，{}", from);
        return from;
        //return R.ok().put("form",from);
    }

    @ApiOperation("支付成功后回调")
    @GetMapping("callback")
    public R payCallback(String orderNo) {
        log.info("支付回调");

        payService.success(orderNo);


        return R.ok();
    }

}
