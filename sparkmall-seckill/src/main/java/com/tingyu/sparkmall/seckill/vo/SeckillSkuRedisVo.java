package com.tingyu.sparkmall.seckill.vo;

import com.tingyu.sparkmall.commons.dto.product.SkuInfoDTO;
import lombok.Data;

import java.math.BigDecimal;

/**
 *
 * 秒杀商品保存到Redis中以及展示给前端的类
 *
 * @Author essionshy
 * @Create 2020/12/11 22:22
 * @Version sparkmall
 */

@Data
public class SeckillSkuRedisVo {

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


    /**
     * Sku 详细信息
     */
    private SkuInfoDTO skuInfoDTO;


    /**
     * 当前商品秒杀的开始时间
     */
    private Long startTime;

    /**
     * 当前商品秒杀的结束时间
     */
    private Long endTime;

    /**
     * 随机码，秒杀开始后，暴露给前端
     */
    private String accessToken;

}
