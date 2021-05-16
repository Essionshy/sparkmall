package com.tingyu.sparkmall.cart.web;

import com.tingyu.sparkmall.cart.service.CartService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/**
 * 购物车
 * @Author essionshy
 * @Create 2020/12/7 23:30
 * @Version renren-fast
 */
@Controller
@RequestMapping("/cart")
public class CartController {


    @Resource
    private CartService cartService;

    @GetMapping("/add")
    public String addToCart(@RequestParam("skuId") String skuId, @RequestParam("count") Integer count){
        cartService.addToCart(skuId,count);
        return "redirect:http://cart.sparkmall.com/cart/successCart.html";
    }



    @GetMapping("/successCart.html")
    public String getCartSuccessPage(){
        return "success";
    }


}
