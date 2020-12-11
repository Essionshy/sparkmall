package com.tingyu.sparkmall.ware.dao;

import com.tingyu.sparkmall.ware.entity.UndoLogEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * AT transaction mode undo table
 * 
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-12-11 16:54:33
 */
@Mapper
public interface UndoLogDao extends BaseMapper<UndoLogEntity> {
	
}
