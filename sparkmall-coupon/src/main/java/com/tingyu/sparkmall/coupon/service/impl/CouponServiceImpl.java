package com.tingyu.sparkmall.coupon.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tingyu.sparkmall.commons.dto.CouponDTO;
import com.tingyu.sparkmall.coupon.dao.CouponDao;
import com.tingyu.sparkmall.coupon.entity.CouponEntity;
import com.tingyu.sparkmall.coupon.service.CouponService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author essionshy
 * @Create 2020/12/5 12:19
 * @Version renren-fast
 */
@Service
@Slf4j
public class CouponServiceImpl extends ServiceImpl<CouponDao, CouponEntity> implements CouponService {

    /**
     * 添加本地事务
     *
     * @param coupon
     * @return
     */
    @Transactional()
    @Override
    public boolean save(CouponDTO coupon) {
        if (null == coupon) {
            return false;
        }
        CouponEntity couponEntity = new CouponEntity();
        BeanUtils.copyProperties(coupon, couponEntity);
        int count = baseMapper.insert(couponEntity);
        return count > 0;
    }
}
