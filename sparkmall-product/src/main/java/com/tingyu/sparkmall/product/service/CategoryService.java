package com.tingyu.sparkmall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tingyu.sparkmall.commons.utils.PageUtils;
import com.tingyu.sparkmall.product.entity.CategoryEntity;
import com.tingyu.sparkmall.product.vo.CategoryVo;

import java.util.List;
import java.util.Map;

/**
 * 商品三级分类
 *
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-12-13 14:23:41
 */
public interface CategoryService extends IService<CategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 获取三级分类菜单树
     * @return
     */
    List<CategoryVo> listCategoryTree();

}

