package com.tingyu.sparkmall.member.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 收货地址表
 * 
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-12-13 14:22:54
 */
@Data
@TableName("ums_member_address")
public class MemberAddressEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId(type = IdType.AUTO)
	private Long id;
	/**
	 * member_id
	 */
	private Long memberId;
	/**
	 * 收货人
	 */
	private String name;
	/**
	 * 电话
	 */
	private String phone;
	/**
	 * 右边
	 */
	private String postCode;
	/**
	 * 省份
	 */
	private String province;
	/**
	 * 城市
	 */
	private String city;
	/**
	 * 区
	 */
	private String region;
	/**
	 * 详细地址
	 */
	private String address;
	/**
	 * 是否默认地址
	 */
	private Integer defaultStatus;

}
