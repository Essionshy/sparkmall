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

import com.tingyu.sparkmall.order.entity.UndoLogEntity;
import com.tingyu.sparkmall.order.service.UndoLogService;
import com.tingyu.sparkmall.commons.utils.PageUtils;
import com.tingyu.sparkmall.commons.utils.R;



/**
 * AT transaction mode undo table
 *
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-12-11 16:35:37
 */
@RestController
@RequestMapping("order/undolog")
public class UndoLogController {
    @Autowired
    private UndoLogService undoLogService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("order:undolog:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = undoLogService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{branchId}")
    @RequiresPermissions("order:undolog:info")
    public R info(@PathVariable("branchId") Long branchId){
		UndoLogEntity undoLog = undoLogService.getById(branchId);

        return R.ok().put("undoLog", undoLog);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("order:undolog:save")
    public R save(@RequestBody UndoLogEntity undoLog){
		undoLogService.save(undoLog);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("order:undolog:update")
    public R update(@RequestBody UndoLogEntity undoLog){
		undoLogService.updateById(undoLog);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("order:undolog:delete")
    public R delete(@RequestBody Long[] branchIds){
		undoLogService.removeByIds(Arrays.asList(branchIds));

        return R.ok();
    }

}
