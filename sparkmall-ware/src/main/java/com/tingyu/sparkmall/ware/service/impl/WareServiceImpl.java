package com.tingyu.sparkmall.ware.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tingyu.sparkmall.dto.WareDTO;
import com.tingyu.sparkmall.ware.entity.WareEntity;
import com.tingyu.sparkmall.ware.mapper.WareMapper;
import com.tingyu.sparkmall.ware.param.WareParam;
import com.tingyu.sparkmall.ware.service.WareService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;

/**
 * @Author essionshy
 * @Create 2020/11/27 22:50
 * @Version renren-fast
 */
@Service
@Slf4j
public class WareServiceImpl implements WareService {


    @Autowired
    private WareMapper wareMapper;

    @Override
    public WareDTO getByProductNo(String productNo) {
        QueryWrapper<WareEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("product_no", productNo);

        WareEntity wareEntity1 = wareMapper.selectById(1332658883357454338L);

        WareEntity wareEntity = wareMapper.selectOne(wrapper);
        if (wareEntity == null) {
            return null;
        }

        WareDTO wareDTO = new WareDTO();
        BeanUtils.copyProperties(wareEntity, wareDTO);
        return wareDTO;
    }

    @Override
    public boolean decreate(String productNo, BigDecimal count) {

        QueryWrapper<WareEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("product_no", productNo);

        WareEntity wareEntity = wareMapper.selectOne(wrapper);
        BigDecimal ware = wareEntity.getCount();
        BigDecimal newCount = ware.subtract(count);
        log.info("剩余库存数量：{}", newCount.toString());
        wareEntity.setCount(newCount);

        int retValue = wareMapper.updateById(wareEntity);

        return retValue > 0;
    }

    @Override
    public boolean save(WareParam param) {

        if (param == null) {
            return false;
        }
        WareEntity wareEntity = new WareEntity();
        BeanUtils.copyProperties(param, wareEntity);
        int count = wareMapper.insert(wareEntity);
        return count > 0;
    }

    @Override
    public boolean update(@RequestBody WareParam param) {

        if (param == null) {
            return false;
        }
        WareEntity wareEntity = wareMapper.getByProductNo(param.getProductNo());
        if (null == wareEntity) {
            return false;
        }
        wareEntity.setProductNo(param.getProductNo());


        wareEntity.setCount(wareEntity.getCount().add(param.getCount()));

        int count = wareMapper.updateById(wareEntity);

        return count > 0;
    }
}
