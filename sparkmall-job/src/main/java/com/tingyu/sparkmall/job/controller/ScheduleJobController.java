package com.tingyu.sparkmall.job.controller; /**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 * <p>
 * https://www.renren.io
 * <p>
 * 版权所有，侵权必究！
 */


import com.tingyu.sparkmall.commons.annotation.SysLog;
import com.tingyu.sparkmall.commons.utils.PageUtils;
import com.tingyu.sparkmall.commons.utils.R;
import com.tingyu.sparkmall.commons.validator.ValidatorUtils;
import com.tingyu.sparkmall.job.entity.ScheduleJobEntity;
import com.tingyu.sparkmall.job.service.ScheduleJobService;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 定时任务
 *
 * @author Mark sunlightcs@gmail.com
 */
@RestController
@RequestMapping("/job/schedule")
public class ScheduleJobController {

    @Resource
    private ScheduleJobService scheduleJobService;

    @Resource
    private ApplicationContext ctx;


    /**
     * 定时任务列表
     */
    @SysLog
    @ApiOperation("分页查询定时任务列表")
    @PostMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = scheduleJobService.queryPage(params);

        return R.ok().put("page", page);
    }

    /**
     * 定时任务信息
     */
    @SysLog
    @ApiOperation("根据任务ID查询定时任务信息")
    @GetMapping("/info/{jobId}")
    public R info(@PathVariable("jobId") Long jobId) {
        ScheduleJobEntity schedule = scheduleJobService.getById(jobId);
        return R.ok().put("schedule", schedule);
    }

    /**
     * 保存定时任务
     */
    @SysLog
    @ApiOperation("保存定时任务")
    @PostMapping("/save")
    public R save(@RequestBody ScheduleJobEntity scheduleJob) {
        ValidatorUtils.validateEntity(scheduleJob);
        scheduleJobService.saveJob(scheduleJob);
        return R.ok();
    }

    /**
     * 修改定时任务
     */
    @SysLog
    @ApiOperation("修改定时任务")
    @PutMapping("/update")
    public R update(@RequestBody ScheduleJobEntity scheduleJob) {
        ValidatorUtils.validateEntity(scheduleJob);

        scheduleJobService.update(scheduleJob);

        return R.ok();
    }

    /**
     * 删除定时任务
     */
    @SysLog
    @ApiOperation("删除定时任务")
    @DeleteMapping("/delete")
    public R delete(@RequestBody Long[] jobIds) {
        scheduleJobService.deleteBatch(jobIds);

        return R.ok();
    }

    /**
     * 立即执行任务
     */
    @SysLog
    @ApiOperation("立即执行任务")
    @PostMapping("/run")
    public R run(@RequestBody Long[] jobIds) {
        scheduleJobService.run(jobIds);

        return R.ok();
    }

    /**
     * 暂停定时任务
     */
    @SysLog
    @ApiOperation("暂停定时任务")
    @PostMapping("/pause")
    public R pause(@RequestBody Long[] jobIds) {

        scheduleJobService.pause(jobIds);

        return R.ok();
    }

    /**
     * 恢复定时任务
     */
    @SysLog
    @ApiOperation("恢复定时任务")
    @PostMapping("/resume")
    public R resume(@RequestBody Long[] jobIds) {
        scheduleJobService.resume(jobIds);

        return R.ok();
    }

}
