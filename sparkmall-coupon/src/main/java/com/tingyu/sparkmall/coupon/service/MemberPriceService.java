package com.tingyu.sparkmall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tingyu.sparkmall.commons.utils.PageUtils;
import com.tingyu.sparkmall.coupon.entity.MemberPriceEntity;

import java.util.Map;

/**
 * 鍟嗗搧浼氬憳浠锋牸
 *
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-12-11 16:58:02
 */
public interface MemberPriceService extends IService<MemberPriceEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

