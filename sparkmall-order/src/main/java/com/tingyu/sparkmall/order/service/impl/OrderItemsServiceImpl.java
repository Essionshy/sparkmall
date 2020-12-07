package com.tingyu.sparkmall.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tingyu.sparkmall.commons.dto.ProductDTO;
import com.tingyu.sparkmall.order.entity.OrderItemsEntity;
import com.tingyu.sparkmall.order.mapper.OrderItemsMapper;
import com.tingyu.sparkmall.order.service.OrderItemsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author essionshy
 * @Create 2020/12/2 17:27
 * @Version renren-fast
 */
@Slf4j
@Service
public class OrderItemsServiceImpl extends ServiceImpl<OrderItemsMapper, OrderItemsEntity> implements OrderItemsService {
    @Override
    public boolean saveProducts(List<ProductDTO> products, String orderNo) {
        if (products == null || orderNo == null || StringUtils.isEmpty(orderNo)) {
            return false;
        }
        if (products.size() <= 0) {
            return false;
        }

        List<OrderItemsEntity> entities = new ArrayList<>();
        for (ProductDTO product : products) {
            OrderItemsEntity entity = new OrderItemsEntity();
            entity.setOrderNo(orderNo);
            entity.setProductNo(product.getProductNo());
            entity.setCount(product.getCount());
            entities.add(entity);
        }

        return this.saveBatch(entities);
    }

    @Override
    public List<ProductDTO> listByOrderNo(String orderNo) {
        if (null == orderNo || StringUtils.isEmpty(orderNo)) {
            return null;
        }
        QueryWrapper<OrderItemsEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("order_no", orderNo);
        List<OrderItemsEntity> entities = baseMapper.selectList(wrapper);

        if (entities == null) {
            return null;
        }
        if (entities.size() <= 0) {
            return null;
        }

        List<ProductDTO> productDTOS = new ArrayList<>();

        for (OrderItemsEntity entity : entities) {
            ProductDTO productDTO = new ProductDTO();
            BeanUtils.copyProperties(entity, productDTO);
            productDTOS.add(productDTO);
        }
        return productDTOS;
    }
}
