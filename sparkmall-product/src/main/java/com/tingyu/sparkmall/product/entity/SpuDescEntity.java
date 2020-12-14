package com.tingyu.sparkmall.product.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * spu信息介绍
 * 
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-12-13 14:23:41
 */
@Data
@TableName("pms_spu_desc")
public class SpuDescEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 商品id
	 */
	@TableId(type = IdType.AUTO)
	private Long spuId;
	/**
	 * 商品介绍
	 */
	private String decript;

}
