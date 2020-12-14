package com.tingyu.sparkmall.product.controller;

import com.tingyu.sparkmall.commons.utils.PageUtils;
import com.tingyu.sparkmall.commons.utils.R;
import com.tingyu.sparkmall.product.entity.CategoryEntity;
import com.tingyu.sparkmall.product.service.CategoryService;
import com.tingyu.sparkmall.product.vo.CategoryVo;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;



/**
 * 商品三级分类
 *
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-12-13 14:23:41
 */
@RestController
@RequestMapping("product/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("product:category:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = categoryService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("product:category:info")
    public R info(@PathVariable("id") Long id){
		CategoryEntity category = categoryService.getById(id);

        return R.ok().put("category", category);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("product:category:save")
    public R save(@RequestBody CategoryEntity category){
		categoryService.save(category);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("product:category:update")
    public R update(@RequestBody CategoryEntity category){
		categoryService.updateById(category);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("product:category:delete")
    public R delete(@RequestBody Long[] ids){
		categoryService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

    @ApiOperation("获取三级分类的树形菜单列表")
    @GetMapping("list/tree")
    public R listCategoryTree(){
        List<CategoryVo> categoryVos = categoryService.listCategoryTree();
        return R.ok().put("items",categoryVos);
    }


}
