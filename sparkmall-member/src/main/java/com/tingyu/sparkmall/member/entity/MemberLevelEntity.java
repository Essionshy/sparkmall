package com.tingyu.sparkmall.member.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 浼氬憳绛夌骇琛
 * 
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-12-11 16:51:21
 */
@Data
@TableName("ums_member_level")
public class MemberLevelEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * 绛夌骇鍚嶇О
	 */
	private String name;
	/**
	 * 绛夌骇闇??鐨勬垚闀垮?
	 */
	private Integer growthPoint;
	/**
	 * 榛樿?绛夌骇
	 */
	private Integer defaultStatus;
	/**
	 * 鍏嶈繍璐规爣鍑
	 */
	private BigDecimal freeFreightPoint;
	/**
	 * 姣忔?璇勪环鑾峰彇鐨勬垚闀垮?
	 */
	private Integer commentGrowthPoint;
	/**
	 * 鏄?惁鏈夊厤閭?壒鏉
	 */
	private Integer priviledgeFreeFreight;
	/**
	 * 鏄?惁鏈変細鍛樹环鏍肩壒鏉
	 */
	private Integer priviledgeMemberPrice;
	/**
	 * 鏄?惁鏈夌敓鏃ョ壒鏉
	 */
	private Integer priviledgeBirthday;
	/**
	 * 澶囨敞
	 */
	private String remark;

}
