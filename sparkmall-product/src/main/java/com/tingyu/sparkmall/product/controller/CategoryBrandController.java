package com.tingyu.sparkmall.product.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tingyu.sparkmall.product.entity.CategoryBrandEntity;
import com.tingyu.sparkmall.product.service.CategoryBrandService;
import com.tingyu.sparkmall.commons.utils.PageUtils;
import com.tingyu.sparkmall.commons.utils.R;



/**
 * 鍝佺墝鍒嗙被鍏宠仈
 *
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-12-11 16:40:28
 */
@RestController
@RequestMapping("product/categorybrand")
public class CategoryBrandController {
    @Autowired
    private CategoryBrandService categoryBrandService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("product:categorybrand:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = categoryBrandService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("product:categorybrand:info")
    public R info(@PathVariable("id") Long id){
		CategoryBrandEntity categoryBrand = categoryBrandService.getById(id);

        return R.ok().put("categoryBrand", categoryBrand);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("product:categorybrand:save")
    public R save(@RequestBody CategoryBrandEntity categoryBrand){
		categoryBrandService.save(categoryBrand);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("product:categorybrand:update")
    public R update(@RequestBody CategoryBrandEntity categoryBrand){
		categoryBrandService.updateById(categoryBrand);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("product:categorybrand:delete")
    public R delete(@RequestBody Long[] ids){
		categoryBrandService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
