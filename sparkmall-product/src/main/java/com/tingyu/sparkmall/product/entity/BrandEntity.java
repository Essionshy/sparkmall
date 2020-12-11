package com.tingyu.sparkmall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 鍝佺墝
 * 
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-12-11 16:40:28
 */
@Data
@TableName("pms_brand")
public class BrandEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 鍝佺墝id
	 */
	@TableId
	private Long id;
	/**
	 * 鍝佺墝鍚
	 */
	private String name;
	/**
	 * 鍝佺墝logo
	 */
	private String logo;
	/**
	 * 鏄剧ず鐘舵?[0-涓嶆樉绀猴紱1-鏄剧ず]
	 */
	private Integer status;
	/**
	 * 妫?储棣栧瓧姣
	 */
	private String firstLetter;
	/**
	 * 鎺掑簭
	 */
	private Integer sort;
	/**
	 * 澶囨敞
	 */
	private String remark;

}
