package com.tingyu.sparkmall.coupon.dao;

import com.tingyu.sparkmall.coupon.entity.CouponSpuEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券与产品关联
 * 
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-12-13 14:21:15
 */
@Mapper
public interface CouponSpuDao extends BaseMapper<CouponSpuEntity> {
	
}
