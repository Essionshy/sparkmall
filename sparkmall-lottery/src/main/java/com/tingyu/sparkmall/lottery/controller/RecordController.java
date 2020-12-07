package com.tingyu.sparkmall.lottery.controller;

import com.tingyu.sparkmall.commons.utils.PageUtils;
import com.tingyu.sparkmall.commons.utils.R;
import com.tingyu.sparkmall.lottery.entity.RecordEntity;
import com.tingyu.sparkmall.lottery.service.RecordService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-05-11 14:20:55
 */
@RestController
@RequestMapping("/lottery/record")
public class RecordController {
    @Autowired
    private RecordService recordService;

    /**
     * 列表
     */
    @ApiOperation("条件分页查询中奖记录列表")
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = recordService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @ApiOperation("根据中奖记录编号查询中奖记录信息")
    @RequestMapping("/info/{recordId}")
    public R info(@PathVariable("recordId") Long recordId) {
        RecordEntity record = recordService.getById(recordId);

        return R.ok().put("record", record);
    }

    /**
     * 保存
     */
    @ApiOperation("保存中奖记录信息")
    @RequestMapping("/save")
    public R save(@RequestBody RecordEntity record) {
        recordService.save(record);

        return R.ok();
    }

    /**
     * 修改
     */
    @ApiOperation("更新中奖记录信息")
    @RequestMapping("/update")
    public R update(@RequestBody RecordEntity record) {
        recordService.updateById(record);

        return R.ok();
    }

    /**
     * 删除
     */
    @ApiOperation("删除中奖记录信息")
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] recordIds) {
        recordService.removeByIds(Arrays.asList(recordIds));

        return R.ok();
    }

}
