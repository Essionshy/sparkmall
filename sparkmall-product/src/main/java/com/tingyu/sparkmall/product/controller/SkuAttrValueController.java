package com.tingyu.sparkmall.product.controller;

import com.tingyu.sparkmall.commons.utils.PageUtils;
import com.tingyu.sparkmall.commons.utils.R;
import com.tingyu.sparkmall.product.entity.SkuAttrValueEntity;
import com.tingyu.sparkmall.product.service.SkuAttrValueService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;



/**
 * sku閿?敭灞炴?&鍊
 *
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-12-11 16:40:28
 */
@RestController
@RequestMapping("product/skuattrvalue")
public class SkuAttrValueController {
    @Autowired
    private SkuAttrValueService skuAttrValueService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("product:skuattrvalue:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = skuAttrValueService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("product:skuattrvalue:info")
    public R info(@PathVariable("id") Long id){
		SkuAttrValueEntity skuAttrValue = skuAttrValueService.getById(id);

        return R.ok().put("skuAttrValue", skuAttrValue);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("product:skuattrvalue:save")
    public R save(@RequestBody SkuAttrValueEntity skuAttrValue){
		skuAttrValueService.save(skuAttrValue);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("product:skuattrvalue:update")
    public R update(@RequestBody SkuAttrValueEntity skuAttrValue){
		skuAttrValueService.updateById(skuAttrValue);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("product:skuattrvalue:delete")
    public R delete(@RequestBody Long[] ids){
		skuAttrValueService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
