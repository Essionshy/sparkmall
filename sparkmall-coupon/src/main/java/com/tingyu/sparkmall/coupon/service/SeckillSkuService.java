package com.tingyu.sparkmall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tingyu.sparkmall.commons.utils.PageUtils;
import com.tingyu.sparkmall.coupon.entity.SeckillSkuEntity;

import java.util.Map;

/**
 * 绉掓潃娲诲姩鍟嗗搧鍏宠仈
 *
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-12-11 16:58:02
 */
public interface SeckillSkuService extends IService<SeckillSkuEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

