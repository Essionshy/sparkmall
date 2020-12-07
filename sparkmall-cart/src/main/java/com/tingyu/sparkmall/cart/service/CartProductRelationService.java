package com.tingyu.sparkmall.cart.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tingyu.sparkmall.cart.entity.CartProductRelationEntity;
import com.tingyu.sparkmall.cart.param.CartParam;

import java.util.List;

/**
 * @Author essionshy
 * @Create 2020/12/2 10:54
 * @Version renren-fast
 */
public interface CartProductRelationService extends IService<CartProductRelationEntity> {
    List<String> listByMemberNo(String memberNo);

    boolean isExists(String memberNo, String productNo);

    boolean saveProduct(CartParam param);


    boolean updateProduct(CartParam param);

    boolean updateProductCount(String memberNo, String productNo, boolean isAdd);

    CartProductRelationEntity getByMemberNoAndProductNo(String memberNo, String productNo);
}
