package com.tingyu.sparkmall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tingyu.sparkmall.commons.dto.ProductDTO;
import com.tingyu.sparkmall.order.entity.OrderItemsEntity;

import java.util.List;

/**
 * @Author essionshy
 * @Create 2020/12/2 17:27
 * @Version renren-fast
 */

public interface OrderItemsService extends IService<OrderItemsEntity> {
    boolean saveProducts(List<ProductDTO> products, String orderNo);

    List<ProductDTO> listByOrderNo(String orderNo);
}
