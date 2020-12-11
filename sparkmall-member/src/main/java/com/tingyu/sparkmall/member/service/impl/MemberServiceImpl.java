package com.tingyu.sparkmall.member.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tingyu.sparkmall.commons.dto.MemberDTO;
import com.tingyu.sparkmall.commons.utils.PageUtils;
import com.tingyu.sparkmall.commons.utils.Query;
import com.tingyu.sparkmall.member.dao.MemberDao;
import com.tingyu.sparkmall.member.entity.MemberEntity;
import com.tingyu.sparkmall.member.exception.MemberNotFoundException;
import com.tingyu.sparkmall.member.exception.PasswordNotMatchedException;
import com.tingyu.sparkmall.member.exception.PhoneExistsException;
import com.tingyu.sparkmall.member.exception.UsernameExistsException;
import com.tingyu.sparkmall.member.param.MemberLoginParam;
import com.tingyu.sparkmall.member.param.MemberRegisterParam;
import com.tingyu.sparkmall.member.service.MemberLevelService;
import com.tingyu.sparkmall.member.service.MemberService;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;


@Service("memberService")
public class MemberServiceImpl extends ServiceImpl<MemberDao, MemberEntity> implements MemberService {


    @Resource
    private MemberLevelService memberLevelService;


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<MemberEntity> page = this.page(
                new Query<MemberEntity>().getPage(params),
                new QueryWrapper<MemberEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public void register(MemberRegisterParam param) throws Exception {

        //用户名唯一性校验

        validateUsernameUnique(param.getUsername());
        //手机号唯一性校验
        validatePhoneUnique(param.getPhone());

        //保存会员基本信息到数据库
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setUsername(param.getUsername());
        memberEntity.setPhone(param.getPhone());
        //设置会员默认等级

        Long defaultLevel = memberLevelService.getDefaultLevelId();
        memberEntity.setLevelId(defaultLevel);

        //密码加密保存

        String password = param.getPassword();
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodePassword = passwordEncoder.encode(password);
        memberEntity.setPassword(encodePassword);
        this.save(memberEntity);

    }


    @Override
    public void validateUsernameUnique(String username) throws UsernameExistsException {

        MemberEntity member = baseMapper.selectOne(new QueryWrapper<MemberEntity>().eq("username", username));

        if (member != null) {
            throw new UsernameExistsException();
        }

    }

    @Override
    public void validatePhoneUnique(String phone) throws PhoneExistsException {
        MemberEntity member = baseMapper.selectOne(new QueryWrapper<MemberEntity>().eq("phone", phone));

        if (member != null) {
            throw new PhoneExistsException();
        }
    }

    @Override
    public MemberDTO login(MemberLoginParam param) throws Exception {
        String account = param.getAccount();

        MemberEntity memberEntity = baseMapper.selectOne(new QueryWrapper<MemberEntity>().eq("username", account).or()
                .eq("phone", account).or()
                .eq("email", account));

        if (memberEntity == null) {
            throw new MemberNotFoundException();
        }

        String entityPassword = memberEntity.getPassword();

        //密码校验
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        boolean matches = passwordEncoder.matches(param.getPassword(), entityPassword);

        if (!matches) {
            throw new PasswordNotMatchedException();
        }

        //将用户返回
        MemberDTO memberDTO = new MemberDTO();
        BeanUtils.copyProperties(memberEntity, memberDTO);
        return memberDTO;

    }


}