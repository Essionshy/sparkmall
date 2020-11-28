package com.tingyu.sparkmall.product.controller;

import com.tingyu.sparkmall.product.service.ThreadPoolService;
import com.tingyu.sparkmall.utils.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @Author essionshy
 * @Create 2020/6/7 16:50
 * @Version renren-fast
 */
@RequestMapping("api/admin/thread/pool/")
@RestController
public class ThreadPoolController {

    @Resource
    ThreadPoolService threadPoolService;

    @GetMapping("status")
    public R status(){
        Map<String, Object> status = threadPoolService.getStatus();
        return R.ok().put("status",status);
    }

    @GetMapping("shutdown")
    public R shutdown(){
        threadPoolService.shutdown();
        return R.ok();
    }
    @GetMapping("start")
    public R start(){
        threadPoolService.start();
        return R.ok();
    }
}
