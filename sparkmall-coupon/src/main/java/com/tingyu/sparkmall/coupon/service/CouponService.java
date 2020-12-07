package com.tingyu.sparkmall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tingyu.sparkmall.commons.dto.CouponDTO;
import com.tingyu.sparkmall.coupon.entity.CouponEntity;

/**
 * @Author essionshy
 * @Create 2020/12/5 12:18
 * @Version renren-fast
 */
public interface CouponService extends IService<CouponEntity> {

    boolean save(CouponDTO coupon);

}
