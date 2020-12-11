package com.tingyu.sparkmall.commons.dto.seckill;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author essionshy
 * @Create 2020/12/11 21:31
 * @Version sparkmall
 */
@Data
public class SeckillSkuDTO {

    /**
     * id
     */

    private Long id;
    /**
     * 促销活动ID
     */
    private Long promotionId;
    /**
     * 促销活动场次ID
     */
    private Long promotionSessionId;
    /**
     * 商品ID
     */
    private Long skuId;
    /**
     * 商品秒杀价格
     */
    private BigDecimal seckillPrice;
    /**
     * 商品秒杀数量
     */
    private BigDecimal seckillCount;
    /**
     * 每人秒杀限购数量
     */
    private BigDecimal seckillLimit;
    /**
     * 秒杀排序
     */
    private Integer seckillSort;

}
