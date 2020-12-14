package com.tingyu.sparkmall.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tingyu.sparkmall.commons.dto.order.OrderItemDTO;
import com.tingyu.sparkmall.commons.utils.PageUtils;
import com.tingyu.sparkmall.commons.utils.Query;
import com.tingyu.sparkmall.order.dao.OrderItemDao;
import com.tingyu.sparkmall.order.entity.OrderItemEntity;
import com.tingyu.sparkmall.order.service.OrderItemService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service("orderItemService")
public class OrderItemServiceImpl extends ServiceImpl<OrderItemDao, OrderItemEntity> implements OrderItemService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OrderItemEntity> page = this.page(
                new Query<OrderItemEntity>().getPage(params),
                new QueryWrapper<OrderItemEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public void saveOrderItems(List<OrderItemDTO> orderItems) {

        if (orderItems != null && orderItems.size() > 0) {
            List<OrderItemEntity> entities = orderItems.stream().map(item -> {
                OrderItemEntity orderItemEntity = new OrderItemEntity();
                BeanUtils.copyProperties(item, orderItemEntity);
                return orderItemEntity;
            }).collect(Collectors.toList());

            this.saveBatch(entities);


        }


    }

}