package com.tingyu.sparkmall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tingyu.sparkmall.commons.utils.PageUtils;
import com.tingyu.sparkmall.commons.utils.Query;
import com.tingyu.sparkmall.product.dao.AttrGroupDao;
import com.tingyu.sparkmall.product.entity.AttrGroupEntity;
import com.tingyu.sparkmall.product.entity.CategoryEntity;
import com.tingyu.sparkmall.product.service.AttrGroupService;
import com.tingyu.sparkmall.product.service.CategoryService;
import com.tingyu.sparkmall.product.vo.AttrGroupVo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;


@Service("attrGroupService")
public class AttrGroupServiceImpl extends ServiceImpl<AttrGroupDao, AttrGroupEntity> implements AttrGroupService {


    @Resource
    private CategoryService categoryService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        //查询分类下的属性分组列表
        QueryWrapper<AttrGroupEntity> queryWrapper = new QueryWrapper<>();

        String categoryId = (String) params.get("categoryId");

        if (!StringUtils.isEmpty(categoryId)) {
            queryWrapper.eq("category_id", categoryId);
        }

        IPage<AttrGroupEntity> page = this.page(
                new Query<AttrGroupEntity>().getPage(params),
                queryWrapper
        );

        return new PageUtils(page);
    }

    @Override
    public AttrGroupVo getInfoById(Long id) {
        AttrGroupEntity entity = getById(id);
        if (entity == null) {
            return null;
        }
        AttrGroupVo vo = new AttrGroupVo();
        BeanUtils.copyProperties(entity, vo);
        vo.setCategoryPath(findCategoryPath(entity.getCategoryId()));
        return vo;
    }

    /**
     * 根据分类ID查询分类完成路径
     *
     * @param categoryId
     * @return
     */
    private Long[] findCategoryPath(Long categoryId) {

        List<Long> categorys = new ArrayList<>();
        List<Long> path = getPath(categoryId, categorys);

        Collections.reverse(path);


        return categorys.toArray(new Long[categorys.size()]);
    }

    /**
     * 递归查询父分类ID的方法
     *
     * @param categoryId
     * @param categorys
     * @return
     */
    private List<Long> getPath(Long categoryId, List<Long> categorys) {
        categorys.add(categoryId);
        CategoryEntity category = categoryService.getById(categoryId);
        if (category.getParentId() != 0) {
            getPath(category.getParentId(), categorys);
        }
        return categorys;
    }


}