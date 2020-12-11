package com.tingyu.sparkmall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tingyu.sparkmall.commons.utils.PageUtils;
import com.tingyu.sparkmall.coupon.entity.SkuBoundsEntity;

import java.util.Map;

/**
 * 鍟嗗搧spu绉?垎璁剧疆
 *
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-12-11 16:58:02
 */
public interface SkuBoundsService extends IService<SkuBoundsEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

