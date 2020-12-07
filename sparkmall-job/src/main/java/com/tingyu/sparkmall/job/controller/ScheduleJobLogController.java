package com.tingyu.sparkmall.job.controller;

import com.tingyu.sparkmall.commons.utils.PageUtils;
import com.tingyu.sparkmall.commons.utils.R;
import com.tingyu.sparkmall.job.entity.ScheduleJobLogEntity;
import com.tingyu.sparkmall.job.service.ScheduleJobLogService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 定时任务日志
 *
 * @author Mark sunlightcs@gmail.com
 */
@RestController
@RequestMapping("/job/scheduleLog")
public class ScheduleJobLogController {

    @Resource
    private ScheduleJobLogService scheduleJobLogService;

    /**
     * 定时任务日志信息
     */
    @GetMapping("/info/{logId}")
    @ApiOperation("定时任务日志信息")
    public R info(@PathVariable("logId") Long logId) {
        ScheduleJobLogEntity log = scheduleJobLogService.getById(logId);

        return R.ok().put("log", log);
    }

    /**
     * 定时任务日志列表
     */
    @ApiOperation("条件分页查询定时任务日志列表")
    @PostMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = scheduleJobLogService.queryPage(params);

        return R.ok().put("page", page);
    }
}
