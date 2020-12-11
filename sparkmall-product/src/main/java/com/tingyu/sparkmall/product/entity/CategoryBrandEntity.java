package com.tingyu.sparkmall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 鍝佺墝鍒嗙被鍏宠仈
 * 
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-12-11 16:40:28
 */
@Data
@TableName("pms_category_brand")
public class CategoryBrandEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 鍝佺墝id
	 */
	private Long brandId;
	/**
	 * 鍒嗙被id
	 */
	private Long categoryId;
	/**
	 * 鍝佺墝鍚嶇О
	 */
	private String brandName;
	/**
	 * 鍒嗙被鍚嶇О
	 */
	private String categoryName;

}
