package com.tingyu.sparkmall.cart.service;

import com.tingyu.sparkmall.cart.param.CartParam;
import com.tingyu.sparkmall.cart.vo.CartVo;

import java.math.BigDecimal;

/**
 * @Author essionshy
 * @Create 2020/12/2 0:29
 * @Version renren-fast
 */
public interface CartService {

    boolean addProduct(CartParam param);

    boolean incrProductCount(CartParam param);

    boolean removeCart(CartParam param);

    Integer getTotalCount(String memberNo);


    BigDecimal getTotalFee(String memberNo);

    boolean decrProductCount(CartParam param);


    CartVo getByMemberNo(String memberNo);

    boolean isExists(String memberNo);
}
