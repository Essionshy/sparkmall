package com.tingyu.sparkmall.member.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 关注店铺表
 * 
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-12-13 14:22:54
 */
@Data
@TableName("ums_member_collect_shop")
public class MemberCollectShopEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId(type = IdType.AUTO)
	private Long id;
	/**
	 * 用户id
	 */
	private Long memberId;
	/**
	 * 店铺id
	 */
	private Long shopId;
	/**
	 * 店铺名
	 */
	private String shopName;
	/**
	 * 店铺logo
	 */
	private String shopLogo;
	/**
	 * 关注时间
	 */
	private Date createtime;

}
