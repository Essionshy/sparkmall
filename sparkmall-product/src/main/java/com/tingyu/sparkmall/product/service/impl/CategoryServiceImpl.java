package com.tingyu.sparkmall.product.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tingyu.sparkmall.product.entity.CategoryEntity;
import com.tingyu.sparkmall.product.mapper.CategoryMapper;
import com.tingyu.sparkmall.product.param.CategoryParam;
import com.tingyu.sparkmall.product.service.CategoryService;
import com.tingyu.sparkmall.product.vo.CategoryVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author essionshy
 * @Create 2020/11/29 11:51
 * @Version renren-fast
 */
@Service
@Slf4j
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, CategoryEntity> implements CategoryService {

    @Override
    public Map<String, Object> listByPage(CategoryParam param) {
        Map<String, Object> map = new HashMap<>();
        Page<CategoryEntity> page = new Page<>(param.getPage(), param.getLimit());
        //执行分页查询
        baseMapper.selectPage(page, null);
        //封装返回结果
        long total = page.getTotal();
        List<CategoryEntity> records = page.getRecords();

        List<CategoryVo> categoryVos = records.stream().map(categoryEntity -> {
            CategoryVo categoryVo = new CategoryVo();
            BeanUtils.copyProperties(categoryEntity, categoryVo);
            return categoryVo;
        }).collect(Collectors.toList());
        map.put("total", total);
        map.put("items", categoryVos);
        return map;
    }

    @Override
    public List<CategoryVo> listAll() {

        List<CategoryEntity> list = this.list();

        if (null == list || list.size() == 0) {
            return null;
        }
        List<CategoryVo> categoryVos = list.stream().map(categoryEntity -> {
            CategoryVo categoryVo = new CategoryVo();
            BeanUtils.copyProperties(categoryEntity, categoryVo);
            return categoryVo;
        }).collect(Collectors.toList());

        return categoryVos;
    }

    @Override
    public boolean saveCategory(CategoryParam param) {
        if (null == param) {
            return false;
        }

        CategoryEntity categoryEntity = new CategoryEntity();
        BeanUtils.copyProperties(param, categoryEntity);
        return baseMapper.insert(categoryEntity) > 0;
    }

    @Override
    public boolean updateCategory(CategoryParam param) {

        if (null == param) {
            return false;
        }

        CategoryEntity categoryEntity = new CategoryEntity();
        BeanUtils.copyProperties(param, categoryEntity);
        return baseMapper.updateById(categoryEntity) > 0;
    }

    @Override
    public CategoryVo getByCategoryId(Long categoryId) {

        CategoryEntity categoryEntity = baseMapper.selectById(categoryId);
        if (null == categoryEntity) {
            return null;

        }
        CategoryVo categoryVo = new CategoryVo();
        BeanUtils.copyProperties(categoryEntity, categoryVo);
        return categoryVo;
    }

    @Override
    public boolean deleteByCategoryId(Long categoryId) {
        return baseMapper.deleteById(categoryId) > 0;
    }
}
