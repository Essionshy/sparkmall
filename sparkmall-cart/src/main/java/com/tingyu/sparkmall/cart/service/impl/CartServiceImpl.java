package com.tingyu.sparkmall.cart.service.impl;

import com.tingyu.sparkmall.cart.feign.ProductFeignService;
import com.tingyu.sparkmall.cart.param.CartParam;
import com.tingyu.sparkmall.cart.service.CartProductRelationService;
import com.tingyu.sparkmall.cart.service.CartService;
import com.tingyu.sparkmall.cart.vo.CartVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author essionshy
 * @Create 2020/12/2 0:29
 * @Version renren-fast
 */
@Service
@Slf4j
public class CartServiceImpl implements CartService {

    @Resource
    private CartProductRelationService relationService;
    @Resource
    private HashOperations<String, String, Object> hashOperations;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private ThreadPoolExecutor mainThreadPoolExecutor;

    /* feign com.tingyu.sparkmall.msg.service*/

    @Resource
    private ProductFeignService productFeignService;


    @Override
    public boolean addProduct(CartParam param) {
        return false;
    }

    @Override
    public boolean incrProductCount(CartParam param) {
        return false;
    }

    @Override
    public boolean removeCart(CartParam param) {
        return false;
    }

    @Override
    public Integer getTotalCount(String memberNo) {
        return null;
    }

    @Override
    public BigDecimal getTotalFee(String memberNo) {
        return null;
    }

    @Override
    public boolean decrProductCount(CartParam param) {
        return false;
    }

    @Override
    public CartVo getByMemberNo(String memberNo) {
        return null;
    }

    @Override
    public boolean isExists(String memberNo) {
        return false;
    }
}
