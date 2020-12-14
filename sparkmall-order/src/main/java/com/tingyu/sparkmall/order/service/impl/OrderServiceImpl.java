package com.tingyu.sparkmall.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tingyu.sparkmall.commons.dto.order.OrderDTO;
import com.tingyu.sparkmall.commons.utils.PageUtils;
import com.tingyu.sparkmall.commons.utils.Query;
import com.tingyu.sparkmall.order.dao.OrderDao;
import com.tingyu.sparkmall.order.entity.OrderEntity;
import com.tingyu.sparkmall.order.service.OrderItemService;
import com.tingyu.sparkmall.order.service.OrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;


@Service("orderService")
public class OrderServiceImpl extends ServiceImpl<OrderDao, OrderEntity> implements OrderService {

    @Resource
    private OrderItemService orderItemService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OrderEntity> page = this.page(
                new Query<OrderEntity>().getPage(params),
                new QueryWrapper<OrderEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public Integer getOrderStatus(String orderNo) {

        baseMapper.getOrderStatus(orderNo);
        return null;
    }

    @Override
    public void deleteByOrderNo(String orderNo) {

        baseMapper.delete(new QueryWrapper<OrderEntity>().eq("order_no", orderNo));
    }

    @Override
    public void create(OrderDTO order) {
        OrderEntity orderEntity = new OrderEntity();
        BeanUtils.copyProperties(order,orderEntity);
        this.save(orderEntity);
        //TODO 扣减库存

        //保存订单明细
        orderItemService.saveOrderItems(order.getOrderItems());

    }

}