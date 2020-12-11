package com.tingyu.sparkmall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tingyu.sparkmall.commons.utils.PageUtils;
import com.tingyu.sparkmall.product.entity.SpuEntity;

import java.util.Map;

/**
 * spu淇℃伅
 *
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-12-11 16:40:28
 */
public interface SpuService extends IService<SpuEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

