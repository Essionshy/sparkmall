package com.tingyu.sparkmall.coupon.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 鍟嗗搧婊″噺淇℃伅
 * 
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-12-11 16:58:02
 */
@Data
@TableName("sms_sku_full_reduction")
public class SkuFullReductionEntity implements Serializable {
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
	 * 婊″?灏
	 */
	private BigDecimal fullPrice;
	/**
	 * 鍑忓?灏
	 */
	private BigDecimal reducePrice;
	/**
	 * 鏄?惁鍙備笌鍏朵粬浼樻儬
	 */
	private Integer addOther;

}
