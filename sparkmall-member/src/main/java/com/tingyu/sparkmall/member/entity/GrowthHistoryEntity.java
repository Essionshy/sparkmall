package com.tingyu.sparkmall.member.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 鎴愰暱绉?垎璁板綍琛
 * 
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-12-11 16:51:21
 */
@Data
@TableName("ums_growth_history")
public class GrowthHistoryEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * 鐢ㄦ埛id
	 */
	private Long memberId;
	/**
	 * 鍒涘缓鏃堕棿
	 */
	private Date createTime;
	/**
	 * 鍙樺姩鏁伴噺
	 */
	private Integer count;
	/**
	 * 澶囨敞
	 */
	private String remark;
	/**
	 * 鏉ユ簮
	 */
	private Integer sourceType;

}
