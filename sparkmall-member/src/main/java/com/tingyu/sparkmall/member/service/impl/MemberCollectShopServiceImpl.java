package com.tingyu.sparkmall.member.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tingyu.sparkmall.commons.utils.PageUtils;
import com.tingyu.sparkmall.commons.utils.Query;

import com.tingyu.sparkmall.member.dao.MemberCollectShopDao;
import com.tingyu.sparkmall.member.entity.MemberCollectShopEntity;
import com.tingyu.sparkmall.member.service.MemberCollectShopService;


@Service("memberCollectShopService")
public class MemberCollectShopServiceImpl extends ServiceImpl<MemberCollectShopDao, MemberCollectShopEntity> implements MemberCollectShopService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<MemberCollectShopEntity> page = this.page(
                new Query<MemberCollectShopEntity>().getPage(params),
                new QueryWrapper<MemberCollectShopEntity>()
        );

        return new PageUtils(page);
    }

}