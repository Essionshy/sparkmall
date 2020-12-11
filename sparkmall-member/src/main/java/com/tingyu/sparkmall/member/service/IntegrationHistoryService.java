package com.tingyu.sparkmall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tingyu.sparkmall.commons.utils.PageUtils;
import com.tingyu.sparkmall.member.entity.IntegrationHistoryEntity;

import java.util.Map;

/**
 * 璐?墿绉?垎璁板綍琛
 *
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-12-11 16:51:21
 */
public interface IntegrationHistoryService extends IService<IntegrationHistoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

