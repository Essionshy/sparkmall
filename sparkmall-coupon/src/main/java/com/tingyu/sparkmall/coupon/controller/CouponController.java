package com.tingyu.sparkmall.coupon.controller;

import com.tingyu.sparkmall.commons.dto.CouponDTO;
import com.tingyu.sparkmall.coupon.service.CouponService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author essionshy
 * @Create 2020/12/5 11:58
 * @Version renren-fast
 */
@RestController
@RequestMapping("coupon")
public class CouponController {

    @Resource
    private CouponService couponService;

    @ApiOperation("添加优惠券")
    @PostMapping("save")
    public boolean save(CouponDTO coupon) {
        return couponService.save(coupon);
    }


}
