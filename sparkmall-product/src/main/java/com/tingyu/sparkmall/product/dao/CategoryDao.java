package com.tingyu.sparkmall.product.dao;

import com.tingyu.sparkmall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-12-13 14:23:41
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}