package com.tingyu.sparkmall.order.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tingyu.sparkmall.order.entity.TblOrderEntity;
import com.tingyu.sparkmall.order.service.TblOrderService;
import com.tingyu.sparkmall.commons.utils.PageUtils;
import com.tingyu.sparkmall.commons.utils.R;



/**
 * 
 *
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-12-11 16:35:37
 */
@RestController
@RequestMapping("order/tblorder")
public class TblOrderController {
    @Autowired
    private TblOrderService tblOrderService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("order:tblorder:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = tblOrderService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("order:tblorder:info")
    public R info(@PathVariable("id") Long id){
		TblOrderEntity tblOrder = tblOrderService.getById(id);

        return R.ok().put("tblOrder", tblOrder);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("order:tblorder:save")
    public R save(@RequestBody TblOrderEntity tblOrder){
		tblOrderService.save(tblOrder);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("order:tblorder:update")
    public R update(@RequestBody TblOrderEntity tblOrder){
		tblOrderService.updateById(tblOrder);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("order:tblorder:delete")
    public R delete(@RequestBody Long[] ids){
		tblOrderService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
