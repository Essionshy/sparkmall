package com.tingyu.sparkmall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tingyu.sparkmall.commons.utils.PageUtils;
import com.tingyu.sparkmall.order.entity.UndoLogEntity;

import java.util.Map;

/**
 * AT transaction mode undo table
 *
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-12-11 16:35:37
 */
public interface UndoLogService extends IService<UndoLogEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

