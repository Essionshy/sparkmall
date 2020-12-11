package com.tingyu.sparkmall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tingyu.sparkmall.commons.utils.PageUtils;
import com.tingyu.sparkmall.coupon.entity.SeckillSkuNoticeEntity;

import java.util.Map;

/**
 * 绉掓潃鍟嗗搧閫氱煡璁㈤槄
 *
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-12-11 16:58:02
 */
public interface SeckillSkuNoticeService extends IService<SeckillSkuNoticeEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

