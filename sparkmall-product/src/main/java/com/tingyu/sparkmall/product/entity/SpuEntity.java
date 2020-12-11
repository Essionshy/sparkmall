package com.tingyu.sparkmall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * spu淇℃伅
 * 
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-12-11 16:40:28
 */
@Data
@TableName("pms_spu")
public class SpuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 鍟嗗搧id
	 */
	@TableId
	private Long id;
	/**
	 * 鍟嗗搧鍚嶇О
	 */
	private String name;
	/**
	 * 鎵?睘鍒嗙被id
	 */
	private Long categoryId;
	/**
	 * 鍝佺墝id
	 */
	private Long brandId;
	/**
	 * 涓婃灦鐘舵?[0 - 涓嬫灦锛? - 涓婃灦]
	 */
	private Integer publishStatus;
	/**
	 * 鍒涘缓鏃堕棿
	 */
	private Date createTime;
	/**
	 * 鏇存柊鏃堕棿
	 */
	private Date updateTime;

}
