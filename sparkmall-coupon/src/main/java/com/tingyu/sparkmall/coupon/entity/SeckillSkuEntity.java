package com.tingyu.sparkmall.coupon.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 绉掓潃娲诲姩鍟嗗搧鍏宠仈
 * 
 * @author essionshy
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
	 * 娲诲姩id
	 */
	private Long promotionId;
	/**
	 * 娲诲姩鍦烘?id
	 */
	private Long promotionSessionId;
	/**
	 * 鍟嗗搧id
	 */
	private Long skuId;
	/**
	 * 绉掓潃浠锋牸
	 */
	private BigDecimal seckillPrice;
	/**
	 * 绉掓潃鎬婚噺
	 */
	private BigDecimal seckillCount;
	/**
	 * 姣忎汉闄愯喘鏁伴噺
	 */
	private BigDecimal seckillLimit;
	/**
	 * 鎺掑簭
	 */
	private Integer seckillSort;

}
