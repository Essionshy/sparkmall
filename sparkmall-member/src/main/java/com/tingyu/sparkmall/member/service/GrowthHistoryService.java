package com.tingyu.sparkmall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tingyu.sparkmall.commons.utils.PageUtils;
import com.tingyu.sparkmall.member.entity.GrowthHistoryEntity;

import java.util.Map;

/**
 * 鎴愰暱绉?垎璁板綍琛
 *
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-12-11 16:51:21
 */
public interface GrowthHistoryService extends IService<GrowthHistoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

