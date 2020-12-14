package com.tingyu.sparkmall.coupon.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tingyu.sparkmall.coupon.entity.CouponSpuCategoryEntity;
import com.tingyu.sparkmall.coupon.service.CouponSpuCategoryService;
import com.tingyu.sparkmall.commons.utils.PageUtils;
import com.tingyu.sparkmall.commons.utils.R;



/**
 * 优惠券分类关联
 *
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-12-13 14:21:15
 */
@RestController
@RequestMapping("coupon/couponspucategory")
public class CouponSpuCategoryController {
    @Autowired
    private CouponSpuCategoryService couponSpuCategoryService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("coupon:couponspucategory:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = couponSpuCategoryService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("coupon:couponspucategory:info")
    public R info(@PathVariable("id") Long id){
		CouponSpuCategoryEntity couponSpuCategory = couponSpuCategoryService.getById(id);

        return R.ok().put("couponSpuCategory", couponSpuCategory);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("coupon:couponspucategory:save")
    public R save(@RequestBody CouponSpuCategoryEntity couponSpuCategory){
		couponSpuCategoryService.save(couponSpuCategory);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("coupon:couponspucategory:update")
    public R update(@RequestBody CouponSpuCategoryEntity couponSpuCategory){
		couponSpuCategoryService.updateById(couponSpuCategory);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("coupon:couponspucategory:delete")
    public R delete(@RequestBody Long[] ids){
		couponSpuCategoryService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
