package com.tingyu.sparkmall.seckill.controller;

import com.tingyu.sparkmall.commons.support.CommonResult;
import com.tingyu.sparkmall.seckill.service.SeckillService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author essionshy
 * @Create 2020/12/11 14:53
 * @Version renren-fast
 */

@RestController
@RequestMapping("/seckill")
public class SeckillController {

    @Resource
    private SeckillService seckillService;

    @ApiOperation("秒杀服务上架")
    @GetMapping("/up")
    public CommonResult up() {
        seckillService.up();
        return CommonResult.success();
    }


}
