package com.tingyu.sparkmall.coupon.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 鍟嗗搧spu绉?垎璁剧疆
 * 
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-12-11 16:58:02
 */
@Data
@TableName("sms_sku_bounds")
public class SkuBoundsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * 
	 */
	private Long skuId;
	/**
	 * 鎴愰暱绉?垎
	 */
	private BigDecimal growBounds;
	/**
	 * 璐?墿绉?垎
	 */
	private BigDecimal buyBounds;
	/**
	 * 浼樻儬鐢熸晥鎯呭喌[1111锛堝洓涓?姸鎬佷綅锛屼粠鍙冲埌宸︼級;0 - 鏃犱紭鎯狅紝鎴愰暱绉?垎鏄?惁璧犻?;1 - 鏃犱紭鎯狅紝璐?墿绉?垎鏄?惁璧犻?;2 - 鏈変紭鎯狅紝鎴愰暱绉?垎鏄?惁璧犻?;3 - 鏈変紭鎯狅紝璐?墿绉?垎鏄?惁璧犻?銆愮姸鎬佷綅0锛氫笉璧犻?锛?锛氳禒閫併?]
	 */
	private Integer work;

}
