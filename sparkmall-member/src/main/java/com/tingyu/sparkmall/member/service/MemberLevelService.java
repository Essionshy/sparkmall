package com.tingyu.sparkmall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tingyu.sparkmall.commons.utils.PageUtils;
import com.tingyu.sparkmall.member.entity.MemberLevelEntity;

import java.util.Map;

/**
 * 会员等级表
 *
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-12-13 14:22:54
 */
public interface MemberLevelService extends IService<MemberLevelEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 会员默认等级ID
     * @return
     */

    Long getDefaultLevelId();
}

