package com.tingyu.sparkmall.member.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tingyu.sparkmall.commons.utils.PageUtils;
import com.tingyu.sparkmall.commons.utils.Query;

import com.tingyu.sparkmall.member.dao.MemberCollectSkuDao;
import com.tingyu.sparkmall.member.entity.MemberCollectSkuEntity;
import com.tingyu.sparkmall.member.service.MemberCollectSkuService;


@Service("memberCollectSkuService")
public class MemberCollectSkuServiceImpl extends ServiceImpl<MemberCollectSkuDao, MemberCollectSkuEntity> implements MemberCollectSkuService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<MemberCollectSkuEntity> page = this.page(
                new Query<MemberCollectSkuEntity>().getPage(params),
                new QueryWrapper<MemberCollectSkuEntity>()
        );

        return new PageUtils(page);
    }

}