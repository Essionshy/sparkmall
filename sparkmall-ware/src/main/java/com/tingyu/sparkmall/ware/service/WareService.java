package com.tingyu.sparkmall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tingyu.sparkmall.commons.dto.ProductDTO;
import com.tingyu.sparkmall.commons.dto.WareDTO;
import com.tingyu.sparkmall.ware.entity.WareEntity;
import com.tingyu.sparkmall.ware.param.WareParam;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @Author essionshy
 * @Create 2020/11/27 22:48
 * @Version renren-fast
 */
public interface WareService extends IService<WareEntity> {


    WareDTO getByProductNo(String productNo);

    boolean decrease(String productNo, BigDecimal count);

    boolean save(WareParam param);

    boolean update(WareParam param);

    Map<String, Object> listByPage(WareParam param);

    boolean decrease(List<ProductDTO> products);

    void deliver(String orderNo);

}
