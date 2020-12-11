package com.tingyu.sparkmall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tingyu.sparkmall.commons.utils.PageUtils;
import com.tingyu.sparkmall.order.entity.TblOrderEntity;

import java.util.Map;

/**
 * 
 *
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-12-11 16:35:37
 */
public interface TblOrderService extends IService<TblOrderEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

