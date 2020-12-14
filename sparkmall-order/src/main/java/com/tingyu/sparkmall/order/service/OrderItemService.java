package com.tingyu.sparkmall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tingyu.sparkmall.commons.dto.order.OrderItemDTO;
import com.tingyu.sparkmall.commons.utils.PageUtils;
import com.tingyu.sparkmall.order.entity.OrderItemEntity;

import java.util.List;
import java.util.Map;

/**
 * 订单项信息
 *
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-12-13 14:22:07
 */
public interface OrderItemService extends IService<OrderItemEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 保存订单明细
     * @param orderItems
     */
    void saveOrderItems(List<OrderItemDTO> orderItems);
}

