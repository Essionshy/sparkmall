package com.tingyu.sparkmall.ware.entity;

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
 * @date 2020-12-11 16:54:33
 */
@Data
@TableName("tbl_ware")
public class TblWareEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 
	 */
	private String name;
	/**
	 * 
	 */
	private String productNo;
	/**
	 * 
	 */
	private BigDecimal total;
	/**
	 * 
	 */
	private BigDecimal used;
	/**
	 * 状态：0 正常 1 禁用
	 */
	private Integer status;
	/**
	 * 删除状态： 0 未删除， 1 已删除
	 */
	private Integer deleted;
	/**
	 * 
	 */
	private Date gmtCreate;
	/**
	 * 
	 */
	private Date gmtModified;

}
