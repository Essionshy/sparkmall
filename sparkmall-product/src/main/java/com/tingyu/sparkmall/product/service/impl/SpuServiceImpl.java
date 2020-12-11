package com.tingyu.sparkmall.product.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tingyu.sparkmall.commons.utils.PageUtils;
import com.tingyu.sparkmall.commons.utils.Query;

import com.tingyu.sparkmall.product.dao.SpuDao;
import com.tingyu.sparkmall.product.entity.SpuEntity;
import com.tingyu.sparkmall.product.service.SpuService;


@Service("spuService")
public class SpuServiceImpl extends ServiceImpl<SpuDao, SpuEntity> implements SpuService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SpuEntity> page = this.page(
                new Query<SpuEntity>().getPage(params),
                new QueryWrapper<SpuEntity>()
        );

        return new PageUtils(page);
    }

}