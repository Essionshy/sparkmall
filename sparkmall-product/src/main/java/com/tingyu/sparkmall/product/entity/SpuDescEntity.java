package com.tingyu.sparkmall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * spu淇℃伅浠嬬粛
 * 
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-12-11 16:40:28
 */
@Data
@TableName("pms_spu_desc")
public class SpuDescEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 鍟嗗搧id
	 */
	@TableId
	private Long spuId;
	/**
	 * 鍟嗗搧浠嬬粛
	 */
	private String decript;

}
