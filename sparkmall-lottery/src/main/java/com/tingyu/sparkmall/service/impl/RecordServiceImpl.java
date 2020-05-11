package com.tingyu.sparkmall.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tingyu.sparkmall.dao.RecordDao;
import com.tingyu.sparkmall.entity.RecordEntity;
import com.tingyu.sparkmall.service.RecordService;
import com.tingyu.sparkmall.utils.PageUtils;
import com.tingyu.sparkmall.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("recordService")
public class RecordServiceImpl extends ServiceImpl<RecordDao, RecordEntity> implements RecordService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<RecordEntity> page = this.page(
                new Query<RecordEntity>().getPage(params),
                new QueryWrapper<RecordEntity>()
        );

        return new PageUtils(page);
    }

}