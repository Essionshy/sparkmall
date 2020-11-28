package com.tingyu.sparkmall.order.controller;

import com.tingyu.sparkmall.order.service.OrderService;
import com.tingyu.sparkmall.order.param.OrderParam;
import com.tingyu.sparkmall.utils.R;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 订单模块
 *
 * @Author essionshy
 * @Create 2020/11/27 22:22
 * @Version renren-fast
 */
@RestController
@RequestMapping("api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;


    @ApiOperation("创建订单")
    @PostMapping("create")
    public R create(@RequestBody OrderParam param) {
        orderService.create(param);
        return R.ok();
    }

    @ApiOperation("根据订单号删除订单")
    @DeleteMapping("delete/{orderNo}")
    public R delete(@PathVariable("orderNo") String orderNo){
        orderService.deleteByOrderNo(orderNo);
        return R.ok();
    }


}
