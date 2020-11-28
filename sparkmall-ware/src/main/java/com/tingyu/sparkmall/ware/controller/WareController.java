package com.tingyu.sparkmall.ware.controller;

import com.tingyu.sparkmall.dto.WareDTO;
import com.tingyu.sparkmall.utils.R;
import com.tingyu.sparkmall.ware.param.WareParam;
import com.tingyu.sparkmall.ware.service.WareService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
 * 库存微服务
 *
 * @Author essionshy
 * @Create 2020/11/27 22:44
 * @Version renren-fast
 */
@RestController
@RequestMapping("api/ware")
public class WareController {


    @Autowired
    private WareService wareService;

    @ApiOperation("新增商品库存")
    @PostMapping("save")
    public R save(WareParam param){

        boolean isSuccess = wareService.save(param);
        if(isSuccess){
            return R.ok();
        }else {
            return R.error();
        }
    }


    @ApiOperation("根据商品号更新库存")
    @PutMapping("update")
    public R update(WareParam param){
        boolean isSuccess = wareService.update(param);
        if(isSuccess){
            return R.ok();
        }else {
            return R.error();
        }
    }

    /*远程调用*/

    @ApiOperation("远程调用查询库存信息")
    @GetMapping("get/{productNo}")
    public WareDTO get(@PathVariable("productNo") String productNo) {

        WareDTO ware = wareService.getByProductNo(productNo);

        return ware;
    }


    @ApiOperation("远程调用扣减库存")
    @PutMapping("decreate/{productNo}/{count}")
    public boolean decreate(@PathVariable("productNo") String productNo, @PathVariable("count") BigDecimal count) {

        return wareService.decreate(productNo, count);

    }



}
