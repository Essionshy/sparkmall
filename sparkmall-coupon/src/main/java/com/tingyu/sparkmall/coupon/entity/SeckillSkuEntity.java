package com.tingyu.sparkmall.coupon.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 秒杀商品实体类
 * 
 * @author essiohy
 * @email 1218817610@qq.com
 * @date 2020-12-11 16:58:02
 */
@Data
@TableName("sms_seckill_sku")
public class SeckillSkuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
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
