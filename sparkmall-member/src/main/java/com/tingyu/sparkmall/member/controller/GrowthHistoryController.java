package com.tingyu.sparkmall.member.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tingyu.sparkmall.member.entity.GrowthHistoryEntity;
import com.tingyu.sparkmall.member.service.GrowthHistoryService;
import com.tingyu.sparkmall.commons.utils.PageUtils;
import com.tingyu.sparkmall.commons.utils.R;



/**
 * 鎴愰暱绉?垎璁板綍琛
 *
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-12-11 16:51:21
 */
@RestController
@RequestMapping("member/growthhistory")
public class GrowthHistoryController {
    @Autowired
    private GrowthHistoryService growthHistoryService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("member:growthhistory:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = growthHistoryService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("member:growthhistory:info")
    public R info(@PathVariable("id") Long id){
		GrowthHistoryEntity growthHistory = growthHistoryService.getById(id);

        return R.ok().put("growthHistory", growthHistory);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("member:growthhistory:save")
    public R save(@RequestBody GrowthHistoryEntity growthHistory){
		growthHistoryService.save(growthHistory);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("member:growthhistory:update")
    public R update(@RequestBody GrowthHistoryEntity growthHistory){
		growthHistoryService.updateById(growthHistory);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("member:growthhistory:delete")
    public R delete(@RequestBody Long[] ids){
		growthHistoryService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
