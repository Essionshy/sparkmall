package com.tingyu.sparkmall.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tingyu.sparkmall.commons.utils.PageUtils;
import com.tingyu.sparkmall.commons.utils.Query;

import com.tingyu.sparkmall.ware.dao.TblWareDao;
import com.tingyu.sparkmall.ware.entity.TblWareEntity;
import com.tingyu.sparkmall.ware.service.TblWareService;


@Service("tblWareService")
public class TblWareServiceImpl extends ServiceImpl<TblWareDao, TblWareEntity> implements TblWareService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<TblWareEntity> page = this.page(
                new Query<TblWareEntity>().getPage(params),
                new QueryWrapper<TblWareEntity>()
        );

        return new PageUtils(page);
    }

}