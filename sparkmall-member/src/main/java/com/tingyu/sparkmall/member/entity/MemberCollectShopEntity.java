package com.tingyu.sparkmall.member.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 鍏虫敞搴楅摵琛
 * 
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-12-11 16:51:21
 */
@Data
@TableName("ums_member_collect_shop")
public class MemberCollectShopEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 鐢ㄦ埛id
	 */
	private Long memberId;
	/**
	 * 搴楅摵id
	 */
	private Long shopId;
	/**
	 * 搴楅摵鍚
	 */
	private String shopName;
	/**
	 * 搴楅摵logo
	 */
	private String shopLogo;
	/**
	 * 鍏虫敞鏃堕棿
	 */
	private Date createtime;

}
