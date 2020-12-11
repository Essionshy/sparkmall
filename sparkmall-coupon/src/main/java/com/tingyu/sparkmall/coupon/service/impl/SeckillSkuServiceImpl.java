package com.tingyu.sparkmall.coupon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tingyu.sparkmall.commons.dto.seckill.SeckillSkuDTO;
import com.tingyu.sparkmall.commons.utils.PageUtils;
import com.tingyu.sparkmall.commons.utils.Query;
import com.tingyu.sparkmall.coupon.dao.SeckillSkuDao;
import com.tingyu.sparkmall.coupon.entity.SeckillSkuEntity;
import com.tingyu.sparkmall.coupon.service.SeckillSkuService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service("seckillSkuService")
public class SeckillSkuServiceImpl extends ServiceImpl<SeckillSkuDao, SeckillSkuEntity> implements SeckillSkuService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SeckillSkuEntity> page = this.page(
                new Query<SeckillSkuEntity>().getPage(params),
                new QueryWrapper<SeckillSkuEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<SeckillSkuDTO> listBySessionId(Long id) {

        List<SeckillSkuEntity> skuEntities = baseMapper.selectList(new QueryWrapper<SeckillSkuEntity>().eq("promotion_session_id", id));

        if(skuEntities!=null && skuEntities.size()>0){

            List<SeckillSkuDTO> collect = skuEntities.stream().map(seckillSkuEntity -> {
                SeckillSkuDTO seckillSkuDTO = new SeckillSkuDTO();
                BeanUtils.copyProperties(seckillSkuEntity,seckillSkuEntity);
                return seckillSkuDTO;
            }).collect(Collectors.toList());

            return collect;

        }

        return null;
    }

}