package com.tingyu.sparkmall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tingyu.sparkmall.commons.utils.PageUtils;
import com.tingyu.sparkmall.member.entity.MemberLevelEntity;

import java.util.Map;

/**
 * 浼氬憳绛夌骇琛
 *
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-12-11 16:51:21
 */
public interface MemberLevelService extends IService<MemberLevelEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

