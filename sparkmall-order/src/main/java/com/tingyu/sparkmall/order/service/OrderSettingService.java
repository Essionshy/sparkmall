package com.tingyu.sparkmall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tingyu.sparkmall.commons.utils.PageUtils;
import com.tingyu.sparkmall.order.entity.OrderSettingEntity;

import java.util.Map;

/**
 * 璁㈠崟閰嶇疆淇℃伅
 *
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-12-11 16:35:37
 */
public interface OrderSettingService extends IService<OrderSettingEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

