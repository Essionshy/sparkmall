package com.tingyu.sparkmall.order.dao;

import com.tingyu.sparkmall.order.entity.UndoLogEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * AT transaction mode undo table
 * 
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-12-11 16:35:37
 */
@Mapper
public interface UndoLogDao extends BaseMapper<UndoLogEntity> {
	
}
