package com.tingyu.sparkmall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * spu灞炴?鍊
 * 
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-12-11 16:40:28
 */
@Data
@TableName("pms_spu_attr_value")
public class SpuAttrValueEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * 鍟嗗搧id
	 */
	private Long spuId;
	/**
	 * 灞炴?id
	 */
	private Long attrId;
	/**
	 * 灞炴?鍚
	 */
	private String attrName;
	/**
	 * 灞炴?鍊
	 */
	private String attrValue;
	/**
	 * 椤哄簭
	 */
	private Integer sort;

}
