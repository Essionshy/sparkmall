package com.tingyu.sparkmall.member.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tingyu.sparkmall.commons.utils.PageUtils;
import com.tingyu.sparkmall.commons.utils.Query;

import com.tingyu.sparkmall.member.dao.IntegrationHistoryDao;
import com.tingyu.sparkmall.member.entity.IntegrationHistoryEntity;
import com.tingyu.sparkmall.member.service.IntegrationHistoryService;


@Service("integrationHistoryService")
public class IntegrationHistoryServiceImpl extends ServiceImpl<IntegrationHistoryDao, IntegrationHistoryEntity> implements IntegrationHistoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<IntegrationHistoryEntity> page = this.page(
                new Query<IntegrationHistoryEntity>().getPage(params),
                new QueryWrapper<IntegrationHistoryEntity>()
        );

        return new PageUtils(page);
    }

}