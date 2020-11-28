package com.tingyu.sparkmall.ware.service;

import com.tingyu.sparkmall.dto.WareDTO;
import com.tingyu.sparkmall.ware.param.WareParam;

import java.math.BigDecimal;

/**
 * @Author essionshy
 * @Create 2020/11/27 22:48
 * @Version renren-fast
 */
public interface WareService {


    WareDTO getByProductNo(String productNo);

    boolean decreate(String productNo, BigDecimal count);

    boolean save(WareParam param);

    boolean update(WareParam param);
}
