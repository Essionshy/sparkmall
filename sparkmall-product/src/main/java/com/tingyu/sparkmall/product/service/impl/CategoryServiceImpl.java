package com.tingyu.sparkmall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tingyu.sparkmall.commons.utils.PageUtils;
import com.tingyu.sparkmall.commons.utils.Query;
import com.tingyu.sparkmall.product.dao.CategoryDao;
import com.tingyu.sparkmall.product.entity.CategoryEntity;
import com.tingyu.sparkmall.product.service.CategoryService;
import com.tingyu.sparkmall.product.vo.CategoryVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryVo> listCategoryTree() {
        List<CategoryVo> categoryVos = new ArrayList<>();
        //查询所有分类
        List<CategoryEntity> entities = this.list();

        if (entities != null && entities.size() > 0) {
            //查出所有一级分类
            categoryVos = entities.stream().filter(entity -> {
                return entity.getParentId() == 0;
            }).map(entity -> {
                CategoryVo categoryVo = new CategoryVo();
                //拷贝基本属性
                BeanUtils.copyProperties(entity, categoryVo);
                //设置
                categoryVo.setChildren(findCategoryChildren(entity, entities));


                return categoryVo;
            }).collect(Collectors.toList());


        }


        return categoryVos;

    }

    /**
     * 查询所有子分类
     *
     * @param entity
     * @param entities
     * @return
     */
    private List<CategoryVo> findCategoryChildren(CategoryEntity entity, List<CategoryEntity> entities) {


        List<CategoryVo> categoryVoList = entities.stream().filter(item -> {
            return item.getParentId() == entity.getId();
        }).map(item -> {
            CategoryVo categoryVo = new CategoryVo();
            //拷贝基本属性
            BeanUtils.copyProperties(item, categoryVo);
            //设置
            categoryVo.setChildren(findCategoryChildren(item, entities));


            return categoryVo;
        }).collect(Collectors.toList());

        return categoryVoList;

    }

}