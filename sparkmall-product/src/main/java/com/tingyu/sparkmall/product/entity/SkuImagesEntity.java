package com.tingyu.sparkmall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * sku鍥剧墖
 * 
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-12-11 16:40:28
 */
@Data
@TableName("pms_sku_images")
public class SkuImagesEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * sku_id
	 */
	private Long skuId;
	/**
	 * 鍥剧墖鍦板潃
	 */
	private String url;
	/**
	 * 鎺掑簭
	 */
	private Integer sort;
	/**
	 * 榛樿?鍥綶0 - 涓嶆槸榛樿?鍥撅紝1 - 鏄?粯璁ゅ浘]
	 */
	private Integer defaultStatus;

}
