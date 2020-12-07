package com.tingyu.sparkmall.member.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.tingyu.sparkmall.commons.dto.MemberDTO;
import com.tingyu.sparkmall.commons.utils.PageUtils;
import com.tingyu.sparkmall.commons.utils.Query;
import com.tingyu.sparkmall.member.dao.MemberDao;
import com.tingyu.sparkmall.member.entity.MemberEntity;
import com.tingyu.sparkmall.member.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Map;

@Service("memberService")
@Slf4j
@DefaultProperties(defaultFallback = "globalFallbackHandler", commandProperties = {
        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
})
public class MemberServiceImpl extends ServiceImpl<MemberDao, MemberEntity> implements MemberService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<MemberEntity> page = this.page(
                new Query<MemberEntity>().getPage(params),
                new QueryWrapper<MemberEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    @HystrixCommand
    public MemberDTO getByMemberNo(String mebmerNo) {

        if (null == mebmerNo || StringUtils.isEmpty(mebmerNo)) {
            return null;
        }
        QueryWrapper<MemberEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("member_no", mebmerNo);
        MemberEntity memberEntity = baseMapper.selectOne(wrapper);

        if (memberEntity == null) {
            return null;
        }
        MemberDTO memberDTO = new MemberDTO();
        BeanUtils.copyProperties(memberEntity, memberDTO);
        return memberDTO;
    }

    /**
     * 全局服务降级处理器
     */
    public MemberDTO globalFallbackHandler() {

        log.info("全局服务降级处理器执行开始...");
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setSuccess(false);
        return memberDTO;
    }
}