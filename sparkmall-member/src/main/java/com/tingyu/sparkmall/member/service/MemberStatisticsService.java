package com.tingyu.sparkmall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tingyu.sparkmall.commons.utils.PageUtils;
import com.tingyu.sparkmall.member.entity.MemberStatisticsEntity;

import java.util.Map;

/**
 * 缁熻?淇℃伅琛
 *
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-12-11 16:51:21
 */
public interface MemberStatisticsService extends IService<MemberStatisticsEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

