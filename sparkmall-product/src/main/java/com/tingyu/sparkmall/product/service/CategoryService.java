package com.tingyu.sparkmall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tingyu.sparkmall.product.entity.CategoryEntity;
import com.tingyu.sparkmall.product.param.CategoryParam;
import com.tingyu.sparkmall.product.vo.CategoryVo;

import java.util.List;
import java.util.Map;

/**
 * @Author essionshy
 * @Create 2020/11/29 11:51
 * @Version renren-fast
 */

public interface CategoryService extends IService<CategoryEntity> {
    /**
     * 分页查询商品分类列表
     *
     * @param param
     * @return
     */
    Map<String, Object> listByPage(CategoryParam param);

    /**
     * 查询所有商品分类列表
     *
     * @return
     */
    List<CategoryVo> listAll();

    boolean saveCategory(CategoryParam param);

    boolean updateCategory(CategoryParam param);

    CategoryVo getByCategoryId(Long categoryId);

    boolean deleteByCategoryId(Long categoryId);

}
