package com.tingyu.sparkmall.order.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * AT transaction mode undo table
 * 
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-12-11 16:35:37
 */
@Data
@TableName("undo_log")
public class UndoLogEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * branch transaction id
	 */
	@TableId
	private Long branchId;
	/**
	 * global transaction id
	 */
	private String xid;
	/**
	 * undo_log context,such as serialization
	 */
	private String context;
	/**
	 * rollback info
	 */
	private Longblob rollbackInfo;
	/**
	 * 0:normal status,1:defense status
	 */
	private Integer logStatus;
	/**
	 * create datetime
	 */
	private Date logCreated;
	/**
	 * modify datetime
	 */
	private Date logModified;

}
