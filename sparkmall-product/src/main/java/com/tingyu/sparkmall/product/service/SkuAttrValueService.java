package com.tingyu.sparkmall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tingyu.sparkmall.commons.utils.PageUtils;
import com.tingyu.sparkmall.product.entity.SkuAttrValueEntity;

import java.util.Map;

/**
 * sku閿?敭灞炴?&鍊
 *
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-12-11 16:40:28
 */
public interface SkuAttrValueService extends IService<SkuAttrValueEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

