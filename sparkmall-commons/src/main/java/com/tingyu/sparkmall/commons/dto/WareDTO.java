package com.tingyu.sparkmall.commons.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 库存传输类
 *
 * @Author essionshy
 * @Create 2020/11/27 22:45
 * @Version renren-fast
 */
@Data
public class WareDTO implements Serializable {


    private String id; //仓库编号

    private String productNo; //商品编号

    private BigDecimal total; //库存

    private BigDecimal used; //库存使用量


}
