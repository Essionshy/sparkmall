package com.tingyu.sparkmall.product.controller;

import com.tingyu.sparkmall.product.entity.ProductEntity;
import com.tingyu.sparkmall.support.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @Author essionshy
 * @Create 2020/4/21 23:55
 * @Version sparkmall
 */
@Slf4j
@RestController
@RequestMapping("/product")
public class ProductController {

    @PostMapping("/list")
    public CommonResult list(@Valid @RequestBody ProductEntity entity) {
        log.info("======================ProductController===========================");

        return new CommonResult(200, "查询成功");
    }
}
