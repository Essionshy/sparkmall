package com.tingyu.sparkmall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tingyu.sparkmall.commons.dto.product.SkuInfoDTO;
import com.tingyu.sparkmall.commons.utils.PageUtils;
import com.tingyu.sparkmall.commons.utils.Query;
import com.tingyu.sparkmall.product.dao.SkuDao;
import com.tingyu.sparkmall.product.entity.SkuEntity;
import com.tingyu.sparkmall.product.service.SkuService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("skuService")
public class SkuServiceImpl extends ServiceImpl<SkuDao, SkuEntity> implements SkuService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SkuEntity> page = this.page(
                new Query<SkuEntity>().getPage(params),
                new QueryWrapper<SkuEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public SkuInfoDTO getSkuInfoById(Long skuId) {

        SkuEntity entity = getById(skuId);

        if (null == entity) {
            return null;
        }
        SkuInfoDTO skuInfoDTO = new SkuInfoDTO();

        BeanUtils.copyProperties(entity, skuInfoDTO);

        return skuInfoDTO;
    }

}