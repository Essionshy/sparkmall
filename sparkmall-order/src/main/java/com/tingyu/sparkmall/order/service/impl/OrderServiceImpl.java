package com.tingyu.sparkmall.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tingyu.sparkmall.dto.WareDTO;
import com.tingyu.sparkmall.exception.ResultException;
import com.tingyu.sparkmall.order.entity.OrderEntity;
import com.tingyu.sparkmall.order.feign.WareFeignService;
import com.tingyu.sparkmall.order.mapper.OrderMapper;
import com.tingyu.sparkmall.order.param.OrderParam;
import com.tingyu.sparkmall.order.service.OrderService;
import com.tingyu.sparkmall.order.utils.OrderNoGeneratorUtil;
import com.tingyu.sparkmall.support.enums.BizCodeEnum;
import com.tingyu.sparkmall.utils.RedisKeys;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author essionshy
 * @Create 2020/11/27 22:30
 * @Version renren-fast
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private WareFeignService wareFeignService;

    @Autowired
    private RedissonClient redisson;

    @Override
    public boolean create(OrderParam param) {

        RLock lock = redisson.getLock(RedisKeys.REDIS_LOCK);

        lock.lock();

        try {
            //减库存
            decreateWare(param);
            //调支付

            //下订单
            saveOrder(param);
            //更新状态

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            //
            if(lock.isLocked() && lock.isHeldByCurrentThread()){
                lock.unlock();
            }
        }

    }

    @Override
    public boolean deleteByOrderNo(String orderNo) {
        QueryWrapper<OrderEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("order_no", orderNo);
        int count = orderMapper.delete(wrapper);
        return count > 0;
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
        OrderEntity orderEntity = new OrderEntity();

        BeanUtils.copyProperties(param, orderEntity);
        orderEntity.setOrderNo(OrderNoGeneratorUtil.getOrderNo()); //设置订单编号
        orderMapper.insert(orderEntity);
    }

    /**
     * 减库存
     *
     * @param param
     */
    private void decreateWare(OrderParam param) {
        if (param == null) {
            return;
        }
        //获取商品编号
        String productNo = param.getProductNo();
        //查询商品库存
        WareDTO wareDTO = wareFeignService.get(productNo);
        if (wareDTO != null && wareDTO.getCount().compareTo(param.getCount()) == 1 || wareDTO.getCount().compareTo(param.getCount()) == 0) {
            //库存充足，可以下单
            wareFeignService.decreate(productNo, param.getCount());
        } else {
            //TODO 通知系统补货
            throw new ResultException(BizCodeEnum.WARE_NOT_ENOUGH.getCode(), BizCodeEnum.WARE_NOT_ENOUGH.getMessage());
        }
    }
}
