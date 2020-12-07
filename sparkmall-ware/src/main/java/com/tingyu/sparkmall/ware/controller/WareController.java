package com.tingyu.sparkmall.ware.controller;

import com.tingyu.sparkmall.commons.dto.ProductDTO;
import com.tingyu.sparkmall.commons.dto.WareDTO;
import com.tingyu.sparkmall.commons.utils.R;
import com.tingyu.sparkmall.ware.param.WareParam;
import com.tingyu.sparkmall.ware.service.WareService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 库存微服务
 *
 * @Author essionshy
 * @Create 2020/11/27 22:44
 * @Version renren-fast
 */
@RestController
@RequestMapping("/ware")
public class WareController {


    @Autowired
    private WareService wareService;

    @ApiOperation("条件分页查询库存列表")
    @PostMapping("list")
    public R list(@RequestBody WareParam param) {

        Map<String, Object> map = wareService.listByPage(param);

        return R.ok().put(map);
    }


    @ApiOperation("新增商品库存")
    @PostMapping("save")
    public R save(WareParam param) {

        boolean isSuccess = wareService.save(param);
        if (isSuccess) {
            return R.ok();
        } else {
            return R.error();
        }
    }


    @ApiOperation("根据商品号更新库存")
    @PostMapping("update")
    public R update(WareParam param) {
        boolean isSuccess = wareService.update(param);
        if (isSuccess) {
            return R.ok();
        } else {
            return R.error();
        }
    }

    @ApiOperation("删除商品库存")
    @DeleteMapping("delete")
    public R delete(@RequestBody Long[] ids) {
        boolean isSuccess = wareService.removeByIds(Arrays.asList(ids));
        if (isSuccess) {
            return R.ok();
        } else {
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

        return wareService.decrease(productNo, count);

    }

    @ApiOperation("批量扣减库存")
    @PostMapping("/ware/decrease")
    public boolean decrease(@RequestBody List<ProductDTO> products) {

        return wareService.decrease(products);
    }

    @ApiOperation("仓库发货通知")
    @GetMapping("/ware/deliver/{orderNo}")
    public void deliver(@PathVariable("orderNo") String orderNo) {
        wareService.deliver(orderNo);
    }

}
