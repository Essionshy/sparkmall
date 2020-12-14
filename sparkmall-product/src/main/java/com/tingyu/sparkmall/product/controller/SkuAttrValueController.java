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

import com.tingyu.sparkmall.product.entity.SkuAttrValueEntity;
import com.tingyu.sparkmall.product.service.SkuAttrValueService;
import com.tingyu.sparkmall.commons.utils.PageUtils;
import com.tingyu.sparkmall.commons.utils.R;



/**
 * sku销售属性&值
 *
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-12-13 14:23:41
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
