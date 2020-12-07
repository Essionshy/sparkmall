package com.tingyu.sparkmall.order.controller;

import com.tingyu.sparkmall.commons.dto.OrderDTO;
import com.tingyu.sparkmall.commons.utils.R;
import com.tingyu.sparkmall.order.param.OrderParam;
import com.tingyu.sparkmall.order.service.OrderService;
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
@RequestMapping("order")
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
    public R delete(@PathVariable("orderNo") String orderNo) {
        orderService.deleteByOrderNo(orderNo);
        return R.ok();
    }

    @ApiOperation("根据订单列表查询订单集合")
    @GetMapping("get/{orderNo}")
    public OrderDTO getByOrderNo(@PathVariable("orderNo") String orderNo) {

        OrderDTO OrderDTO = orderService.getByOrderNo(orderNo);

        return OrderDTO;
    }

    @ApiOperation("根据订单号修改订单状态")
    @GetMapping("order/update/status/{orderNo}/{status}")
    public boolean updateOrderStatus(@PathVariable("orderNo") String orderNo, @PathVariable("status") int status) {

        return orderService.updateOrderStatus(orderNo, status);
    }

}
