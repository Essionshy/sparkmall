package com.tingyu.sparkmall.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tingyu.sparkmall.commons.dto.OrderDTO;
import com.tingyu.sparkmall.commons.dto.ProductDTO;
import com.tingyu.sparkmall.commons.support.enums.OrderStatus;
import com.tingyu.sparkmall.commons.utils.RedisKeys;
import com.tingyu.sparkmall.order.entity.OrderEntity;
import com.tingyu.sparkmall.order.feign.WareFeignService;
import com.tingyu.sparkmall.order.mapper.OrderMapper;
import com.tingyu.sparkmall.order.param.OrderParam;
import com.tingyu.sparkmall.order.service.OrderItemsService;
import com.tingyu.sparkmall.order.service.OrderService;
import com.tingyu.sparkmall.order.utils.OrderNoGeneratorUtil;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author essionshy
 * @Create 2020/11/27 22:30
 * @Version renren-fast
 */
@Service
@Slf4j
public class OrderServiceImpl extends ServiceImpl<OrderMapper, OrderEntity> implements OrderService {


    @Resource
    private OrderItemsService orderItemsService;

    @Resource
    private WareFeignService wareFeignService;

    @Resource
    private RedissonClient redisson;

    /**
     * 开启 seata 事务管理器
     *
     * @param param
     * @return
     */
    @GlobalTransactional(name = "tx_trade", rollbackFor = Throwable.class)
    @Override
    public boolean create(OrderParam param) {

        RLock lock = redisson.getLock(RedisKeys.REDIS_LOCK);
        lock.lock();
        try {
            //下订单
            saveOrder(param);
            //减库存
            wareFeignService.decrease(param.getProducts());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            //判断当前线程是否持有锁
            if (lock.isLocked() && lock.isHeldByCurrentThread()) {
                lock.unlock();
            }
        }
    }

    @Override
    public boolean deleteByOrderNo(String orderNo) {
        QueryWrapper<OrderEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("order_no", orderNo);
        int count = baseMapper.delete(wrapper);
        return count > 0;
    }


    @Override
    public OrderDTO getByOrderNo(String orderNo) {
        QueryWrapper<OrderEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("order_no", orderNo);
        OrderEntity orderEntity = baseMapper.selectOne(wrapper);
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderEntity, orderDTO);
        //设置商品列表
        List<ProductDTO> products = orderItemsService.listByOrderNo(orderNo);
        orderDTO.setProducts(products);
        return orderDTO;
    }

    @Override
    public boolean updateOrderStatus(String orderNo, int status) {
        QueryWrapper<OrderEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("order_no", orderNo);
        OrderEntity orderEntity = baseMapper.selectOne(wrapper);
        orderEntity.setStatus(status);
        return baseMapper.updateById(orderEntity) > 0;
    }

    /**
     * 保存订单
     *
     * @param param
     */
    private void saveOrder(OrderParam param) {
        if (param == null) {
            return;
        }
        //获取购物车中的商品列表

        String orderNo = OrderNoGeneratorUtil.getOrderNo();

        OrderEntity orderEntity = new OrderEntity();
        BeanUtils.copyProperties(param, orderEntity);
        orderEntity.setOrderNo(orderNo); //设置订单编号
        orderEntity.setStatus(OrderStatus.WAIT_PAY.ordinal());//设置订单状态为待支付
        baseMapper.insert(orderEntity);
        //保存商品明细
        orderItemsService.saveProducts(param.getProducts(), orderNo);


    }


}
