package com.tingyu.sparkmall.coupon.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 鍟嗗搧闃舵?浠锋牸
 * 
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-12-11 16:58:02
 */
@Data
@TableName("sms_sku_ladder")
public class SkuLadderEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * spu_id
	 */
	private Long skuId;
	/**
	 * 婊″嚑浠
	 */
	private Integer fullCount;
	/**
	 * 鎵撳嚑鎶
	 */
	private BigDecimal discount;
	/**
	 * 鏄?惁鍙犲姞鍏朵粬浼樻儬[0-涓嶅彲鍙犲姞锛?-鍙?彔鍔燷
	 */
	private Integer addOther;

}
