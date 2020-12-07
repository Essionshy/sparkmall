package com.tingyu.sparkmall.ware.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tingyu.sparkmall.commons.dto.OrderDTO;
import com.tingyu.sparkmall.commons.dto.ProductDTO;
import com.tingyu.sparkmall.commons.dto.WareDTO;
import com.tingyu.sparkmall.commons.exception.ResultException;
import com.tingyu.sparkmall.commons.support.enums.BizCodeEnum;
import com.tingyu.sparkmall.ware.feign.OrderFeignService;
import com.tingyu.sparkmall.ware.entity.WareEntity;
import com.tingyu.sparkmall.ware.mapper.WareMapper;
import com.tingyu.sparkmall.ware.param.WareParam;
import com.tingyu.sparkmall.ware.service.WareService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author essionshy
 * @Create 2020/11/27 22:50
 * @Version renren-fast
 */
@Service
@Slf4j
public class WareServiceImpl extends ServiceImpl<WareMapper, WareEntity> implements WareService {


    @Resource
    private WareMapper wareMapper;

    @Resource
    private OrderFeignService orderFeignService;

    @Override
    public WareDTO getByProductNo(String productNo) {
        QueryWrapper<WareEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("product_no", productNo);


        WareEntity wareEntity = wareMapper.selectOne(wrapper);
        if (wareEntity == null) {
            return null;
        }

        WareDTO wareDTO = new WareDTO();
        BeanUtils.copyProperties(wareEntity, wareDTO);
        return wareDTO;
    }

    @Override
    public boolean decrease(String productNo, BigDecimal count) {
        //int i = 10 / 0;
        //模拟超时异常
        QueryWrapper<WareEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("product_no", productNo);

        WareEntity wareEntity = wareMapper.selectOne(wrapper);
        BigDecimal ware = wareEntity.getTotal();
        //库存总量减少
        BigDecimal newTotal = ware.subtract(count);
        log.info("剩余库存数量：{}", newTotal.toString());
        wareEntity.setTotal(newTotal);
        //库存使用量增加
        BigDecimal used = wareEntity.getUsed();

        BigDecimal newUsed = used.add(count);
        wareEntity.setUsed(newUsed);


        int retValue = wareMapper.updateById(wareEntity);

        return retValue > 0;
    }

    @Override
    public boolean save(WareParam param) {

        if (param == null) {
            return false;
        }
        WareEntity wareEntity = new WareEntity();
        BeanUtils.copyProperties(param, wareEntity);
        int count = wareMapper.insert(wareEntity);
        return count > 0;
    }

    @Override
    public boolean update(@RequestBody WareParam param) {

        if (param == null) {
            return false;
        }
        WareEntity wareEntity = wareMapper.getByProductNo(param.getProductNo());
        if (null == wareEntity) {
            return false;
        }
        wareEntity.setProductNo(param.getProductNo());


        wareEntity.setTotal(wareEntity.getTotal().add(param.getCount()));

        int count = wareMapper.updateById(wareEntity);

        return count > 0;
    }

    @Override
    public Map<String, Object> listByPage(WareParam param) {

        if (null == param) {
            return null;
        }

        QueryWrapper<WareEntity> wrapper = new QueryWrapper<>();
        String productNo = param.getProductNo();
        Integer pageNum = param.getPage();
        Long limit = param.getLimit();

        if (productNo != null && !StringUtils.isEmpty(productNo))
            wrapper.eq("product_no", productNo);


        Page<WareEntity> page = new Page<>(pageNum, limit);

        baseMapper.selectPage(page, wrapper);

        Map<String, Object> map = new HashMap<>();

        map.put("total", page.getTotal());
        map.put("items", page.getRecords());
        return map;
    }

    @Override
    public boolean decrease(List<ProductDTO> products) {


        if (products == null) {
            return false;
        }

        if (products.size() <= 0) {
            return false;
        }
        //遍历扣减库存

        for (ProductDTO product : products) {

            decr(product);

        }

        return false;
    }

    @Override
    public void deliver(String orderNo) {
        //获取订单信息，打印单证

        OrderDTO order = orderFeignService.getByOrderNo(orderNo);


        // TODO 订单通知


    }


    private void decr(ProductDTO product) {

        String productNo = product.getProductNo();

        //获取商品编号
        if (productNo == null || StringUtils.isEmpty(productNo)) {
            return;
        }
        //查询商品库存
        WareDTO wareDTO = this.getByProductNo(productNo);

        //校验
        if (null == wareDTO) {
            return;
        }
        //判断库存是否充足
        if (wareDTO.getTotal().compareTo(new BigDecimal(product.getCount())) == 1 || wareDTO.getTotal().compareTo(new BigDecimal(product.getCount())) == 0) {
            //库存充足，可以下单
            decrease(productNo, new BigDecimal(product.getCount()));
        } else {
            //TODO 通知系统补货
            log.info("库存不足，请及时补货");
            throw new ResultException(BizCodeEnum.WARE_NOT_ENOUGH.getCode(), BizCodeEnum.WARE_NOT_ENOUGH.getMessage());
        }

    }
}
