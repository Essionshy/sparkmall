package com.tingyu.sparkmall.member.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tingyu.sparkmall.commons.utils.PageUtils;
import com.tingyu.sparkmall.commons.utils.Query;

import com.tingyu.sparkmall.member.dao.MemberAddressDao;
import com.tingyu.sparkmall.member.entity.MemberAddressEntity;
import com.tingyu.sparkmall.member.service.MemberAddressService;


@Service("memberAddressService")
public class MemberAddressServiceImpl extends ServiceImpl<MemberAddressDao, MemberAddressEntity> implements MemberAddressService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<MemberAddressEntity> page = this.page(
                new Query<MemberAddressEntity>().getPage(params),
                new QueryWrapper<MemberAddressEntity>()
        );

        return new PageUtils(page);
    }

}