package com.tingyu.sparkmall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * sku淇℃伅
 * 
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-12-11 16:40:28
 */
@Data
@TableName("pms_sku")
public class SkuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * skuId
	 */
	@TableId
	private Long id;
	/**
	 * spuId
	 */
	private Long spuId;
	/**
	 * sku鍚嶇О
	 */
	private String name;
	/**
	 * 鎵?睘鍒嗙被id
	 */
	private Long catagoryId;
	/**
	 * 鍝佺墝id
	 */
	private Long brandId;
	/**
	 * 榛樿?鍥剧墖
	 */
	private String defaultImage;
	/**
	 * 鏍囬?
	 */
	private String title;
	/**
	 * 鍓?爣棰
	 */
	private String subtitle;
	/**
	 * 浠锋牸
	 */
	private BigDecimal price;
	/**
	 * 閲嶉噺锛堝厠锛
	 */
	private Integer weight;

}
