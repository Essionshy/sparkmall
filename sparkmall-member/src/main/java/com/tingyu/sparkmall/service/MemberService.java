package com.tingyu.sparkmall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tingyu.sparkmall.entity.MemberEntity;
import com.tingyu.sparkmall.utils.PageUtils;

import java.util.Map;


/**
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-05-11 22:03:09
 */
public interface MemberService extends IService<MemberEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

