package com.tingyu.sparkmall.member.dao;

import com.tingyu.sparkmall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户表
 * 
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-12-13 14:22:54
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
