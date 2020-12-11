package com.tingyu.sparkmall.member.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tingyu.sparkmall.commons.utils.PageUtils;
import com.tingyu.sparkmall.commons.utils.Query;
import com.tingyu.sparkmall.member.dao.MemberLevelDao;
import com.tingyu.sparkmall.member.entity.MemberLevelEntity;
import com.tingyu.sparkmall.member.service.MemberLevelService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("memberLevelService")
public class MemberLevelServiceImpl extends ServiceImpl<MemberLevelDao, MemberLevelEntity> implements MemberLevelService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<MemberLevelEntity> page = this.page(
                new Query<MemberLevelEntity>().getPage(params),
                new QueryWrapper<MemberLevelEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public Long getDefaultLevelId() {

        MemberLevelEntity memberLevelEntity = baseMapper.selectOne(new QueryWrapper<MemberLevelEntity>().eq("default_status", 1));

        if (memberLevelEntity == null) {
            return null;
        }

        return memberLevelEntity.getId();
    }

}