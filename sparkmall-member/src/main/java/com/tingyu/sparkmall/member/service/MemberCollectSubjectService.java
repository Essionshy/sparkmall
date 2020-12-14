package com.tingyu.sparkmall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tingyu.sparkmall.commons.utils.PageUtils;
import com.tingyu.sparkmall.member.entity.MemberCollectSubjectEntity;

import java.util.Map;

/**
 * 关注活动表
 *
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-12-13 14:22:54
 */
public interface MemberCollectSubjectService extends IService<MemberCollectSubjectEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

