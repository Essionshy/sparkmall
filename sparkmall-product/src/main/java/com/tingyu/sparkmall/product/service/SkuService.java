package com.tingyu.sparkmall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tingyu.sparkmall.commons.dto.product.SkuInfoDTO;
import com.tingyu.sparkmall.commons.utils.PageUtils;
import com.tingyu.sparkmall.product.entity.SkuEntity;

import java.util.Map;

/**
 * sku信息
 *
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-12-13 14:23:41
 */
public interface SkuService extends IService<SkuEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 查询Sku 信息
     * @param skuId
     * @return
     */
    SkuInfoDTO getSkuInfoById(Long skuId);
}

