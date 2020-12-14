package com.tingyu.sparkmall.message.controller;

import com.tingyu.sparkmall.commons.dto.order.OrderDTO;
import com.tingyu.sparkmall.commons.support.CommonResult;
import com.tingyu.sparkmall.message.service.OrderMessageService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author essionshy
 * @Create 2020/12/11 11:05
 * @Version renren-fast
 */
@RestController
@RequestMapping(value = "/message/order")
public class OrderMessageController {

    @Resource
    private OrderMessageService orderMessageService;

    @ApiOperation("发送创建订单消息")
    @PostMapping("create")
    public CommonResult sendOrderCreateMsg(@RequestBody OrderDTO orderDTO){


        orderMessageService.sendOrderCreate(orderDTO);
        return CommonResult.success();
    }



    @ApiOperation("发送延时消息")
    @PostMapping("/delay")
    public CommonResult sendOrderDelayMsg(@RequestBody OrderDTO orderDTO){
        orderMessageService.sendOrderDelayMsg(orderDTO);
        return CommonResult.success();
    }

}
