package com.tingyu.sparkmall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tingyu.sparkmall.commons.dto.MemberDTO;
import com.tingyu.sparkmall.commons.utils.PageUtils;
import com.tingyu.sparkmall.member.entity.MemberEntity;
import com.tingyu.sparkmall.member.exception.PhoneExistsException;
import com.tingyu.sparkmall.member.exception.UsernameExistsException;
import com.tingyu.sparkmall.member.param.MemberLoginParam;
import com.tingyu.sparkmall.member.param.MemberRegisterParam;

import java.util.Map;

/**
 * 鐢ㄦ埛琛
 *
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-12-11 16:51:21
 */
public interface MemberService extends IService<MemberEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 会员注册
     * @param param
     * @throws Exception  用户名已经存在异常，手机号存在异常
     */
    void register(MemberRegisterParam param) throws Exception;

    /**
     * 用户名唯一性校验
     * @param username
     * @throws UsernameExistsException
     */
   void validateUsernameUnique(String username) throws UsernameExistsException;

    /**
     * 手机号唯一性校验
     * @param phone
     * @throws PhoneExistsException
     */
   void validatePhoneUnique(String phone) throws PhoneExistsException;

    /**
     * 用户登录
     * @param param
     */
    MemberDTO login(MemberLoginParam param) throws Exception;

}

