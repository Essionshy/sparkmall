package com.tingyu.sparkmall.order.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tingyu.sparkmall.commons.utils.PageUtils;
import com.tingyu.sparkmall.commons.utils.Query;

import com.tingyu.sparkmall.order.dao.TblOrderDao;
import com.tingyu.sparkmall.order.entity.TblOrderEntity;
import com.tingyu.sparkmall.order.service.TblOrderService;


@Service("tblOrderService")
public class TblOrderServiceImpl extends ServiceImpl<TblOrderDao, TblOrderEntity> implements TblOrderService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<TblOrderEntity> page = this.page(
                new Query<TblOrderEntity>().getPage(params),
                new QueryWrapper<TblOrderEntity>()
        );

        return new PageUtils(page);
    }

}