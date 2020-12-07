package com.tingyu.sparkmall.cart.controller;

import com.tingyu.sparkmall.cart.param.CartParam;
import com.tingyu.sparkmall.cart.service.CartService;
import com.tingyu.sparkmall.cart.vo.CartVo;
import com.tingyu.sparkmall.commons.utils.R;
import groovy.util.logging.Slf4j;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @Author essionshy
 * @Create 2020/12/2 0:27
 * @Version renren-fast
 */
@RestController
@RequestMapping("cart")
@Slf4j
public class CartController {

    @Resource
    private CartService cartService;


    @ApiOperation("查询全部购物车商品列表")
    @GetMapping("get/{memberNo}")
    public R get(@PathVariable("memberNo") String memberNo) {
        CartVo cartVo = cartService.getByMemberNo(memberNo);
        return R.ok().put("item", cartVo);
    }


    @ApiOperation("添加商品到购物车")
    @PostMapping("add")
    public R addProduct(@RequestBody CartParam param) {
        boolean isSuccess = cartService.addProduct(param);
        if (isSuccess) {
            return R.ok();
        } else {

            return R.error();
        }
    }

    @ApiOperation("增加商品数量")
    @PostMapping("incr/count")
    public R incrProductCount(@RequestBody CartParam param) {
        boolean isSuccess = cartService.incrProductCount(param);

        if (isSuccess) {
            return R.ok();
        } else {

            return R.error();
        }
    }

    @ApiOperation("减少商品数量")
    @PostMapping("decr/count")
    public R decrProductCount(@RequestBody CartParam param) {
        boolean isSuccess = cartService.decrProductCount(param);

        if (isSuccess) {
            return R.ok();
        } else {

            return R.error();
        }
    }

    @ApiOperation("减少商品数量")
    @PostMapping("remove")
    public R remove(@RequestBody CartParam param) {
        boolean isSuccess = cartService.removeCart(param);

        if (isSuccess) {
            return R.ok();
        } else {

            return R.error();
        }
    }

    @ApiOperation("购物车商品总数量")
    @GetMapping("total/count/{memberNo}")
    public R getTotalCount(@PathVariable("memberNo") String memberNo) {
        Integer totalCount = cartService.getTotalCount(memberNo);

        return R.ok().put("totalCount", totalCount);
    }

    @ApiOperation("购物车商品总金额")
    @GetMapping("total/fee/{memberNo}")
    public R getTotalFee(@PathVariable("memberNo") String memberNo) {
        BigDecimal totalFee = cartService.getTotalFee(memberNo);

        return R.ok().put("totalFee", totalFee);
    }
}
