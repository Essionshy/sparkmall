package com.tingyu.sparkmall.cart.service.impl;

import com.tingyu.sparkmall.cart.feign.ProductFeignService;
import com.tingyu.sparkmall.cart.interceptor.CartInterceptor;
import com.tingyu.sparkmall.cart.service.CartService;
import com.tingyu.sparkmall.commons.constant.CartServerConstant;
import com.tingyu.sparkmall.commons.dto.UserInfoDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
    private RedisTemplate redisTemplate;

    @Resource
    private HashOperations<String, String, Object> hashOperations;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private ThreadPoolExecutor mainThreadPoolExecutor;

    /* feign com.tingyu.sparkmall.msg.service*/

    @Resource
    private ProductFeignService productFeignService;

    /**
     * 添加商品项到购物车
     *
     * @param skuId
     * @param count
     */
    @Override
    public void addToCart(String skuId, Integer count) {
        //查询商品项基本信息，并封装







        BoundHashOperations<String, Object, Object> hashOps = getHashOps();




    }

    /**
     * 根据用户登录情况，返回操作 Redis 中购物车项的
     * @return
     */
    private BoundHashOperations<String, Object, Object> getHashOps() {
        UserInfoDTO userInfoDTO = CartInterceptor.threadLocal.get();

        String userKey = "";

        if (userInfoDTO.getUserId() != null) {
            //登录用户
            userKey = CartServerConstant.CART_KEY_PREFIX + userInfoDTO.getUserId();
        } else {
            //游客
            userKey = CartServerConstant.CART_KEY_PREFIX + userInfoDTO.getUserKey();

        }
        //远程查询商品信息,并封装 CartVo对象
        BoundHashOperations<String, Object, Object> hashOps =  redisTemplate.boundHashOps(userKey);
        return hashOps;

    }
}
