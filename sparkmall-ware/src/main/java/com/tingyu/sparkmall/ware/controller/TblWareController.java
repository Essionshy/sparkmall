package com.tingyu.sparkmall.ware.controller;

import com.tingyu.sparkmall.commons.utils.PageUtils;
import com.tingyu.sparkmall.commons.utils.R;
import com.tingyu.sparkmall.ware.entity.TblWareEntity;
import com.tingyu.sparkmall.ware.service.TblWareService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;



/**
 * 
 *
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-12-11 16:54:33
 */
@RestController
@RequestMapping("ware/tblware")
public class TblWareController {
    @Autowired
    private TblWareService tblWareService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("ware:tblware:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = tblWareService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("ware:tblware:info")
    public R info(@PathVariable("id") Long id){
		TblWareEntity tblWare = tblWareService.getById(id);

        return R.ok().put("tblWare", tblWare);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("ware:tblware:save")
    public R save(@RequestBody TblWareEntity tblWare){
		tblWareService.save(tblWare);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("ware:tblware:update")
    public R update(@RequestBody TblWareEntity tblWare){
		tblWareService.updateById(tblWare);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("ware:tblware:delete")
    public R delete(@RequestBody Long[] ids){
		tblWareService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
