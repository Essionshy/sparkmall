package com.tingyu.sparkmall.order.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-12-11 16:35:37
 */
@Data
@TableName("tbl_order")
public class TblOrderEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 
	 */
	private String orderNo;
	/**
	 * 
	 */
	private String username;
	/**
	 * 
	 */
	private String phone;
	/**
	 * 
	 */
	private Integer totalCount;
	/**
	 * 
	 */
	private BigDecimal totalFee;
	/**
	 * 
	 */
	private Integer payType;
	/**
	 * 订单状态
	 */
	private Integer status;
	/**
	 * 
	 */
	private Date gmtCreate;
	/**
	 * 
	 */
	private Date gmtModified;

}
