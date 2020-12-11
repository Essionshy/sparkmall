package com.tingyu.sparkmall.member.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tingyu.sparkmall.commons.utils.PageUtils;
import com.tingyu.sparkmall.commons.utils.Query;

import com.tingyu.sparkmall.member.dao.MemberStatisticsDao;
import com.tingyu.sparkmall.member.entity.MemberStatisticsEntity;
import com.tingyu.sparkmall.member.service.MemberStatisticsService;


@Service("memberStatisticsService")
public class MemberStatisticsServiceImpl extends ServiceImpl<MemberStatisticsDao, MemberStatisticsEntity> implements MemberStatisticsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<MemberStatisticsEntity> page = this.page(
                new Query<MemberStatisticsEntity>().getPage(params),
                new QueryWrapper<MemberStatisticsEntity>()
        );

        return new PageUtils(page);
    }

}