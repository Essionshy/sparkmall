package com.tingyu.sparkmall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tingyu.sparkmall.commons.dto.seckill.SeckillSkuDTO;
import com.tingyu.sparkmall.commons.utils.PageUtils;
import com.tingyu.sparkmall.coupon.entity.SeckillSkuEntity;

import java.util.List;
import java.util.Map;

/**
 * 秒杀活动商品关联
 *
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-12-13 14:21:15
 */
public interface SeckillSkuService extends IService<SeckillSkuEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 根据秒杀场次ID 查询所有秒杀商品Sku信息
     * @param id
     * @return
     */
    List<SeckillSkuDTO> listBySessionId(Long id);
}

