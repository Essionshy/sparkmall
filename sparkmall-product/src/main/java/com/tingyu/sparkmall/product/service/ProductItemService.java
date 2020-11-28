package com.tingyu.sparkmall.product.service;

import com.tingyu.sparkmall.product.entity.ProductEntity;

import java.util.List;

/**
 * @Author essionshy
 * @Create 2020/6/7 18:03
 * @Version renren-fast
 */
public interface ProductItemService {

    public boolean save(ProductEntity productEntity);

    List<ProductEntity> get();

}
