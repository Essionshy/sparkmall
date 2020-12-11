package com.tingyu.sparkmall.member.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 鏀惰揣鍦板潃琛
 * 
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-12-11 16:51:21
 */
@Data
@TableName("ums_member_address")
public class MemberAddressEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * member_id
	 */
	private Long memberId;
	/**
	 * 鏀惰揣浜
	 */
	private String name;
	/**
	 * 鐢佃瘽
	 */
	private String phone;
	/**
	 * 鍙宠竟
	 */
	private String postCode;
	/**
	 * 鐪佷唤
	 */
	private String province;
	/**
	 * 鍩庡競
	 */
	private String city;
	/**
	 * 鍖
	 */
	private String region;
	/**
	 * 璇︾粏鍦板潃
	 */
	private String address;
	/**
	 * 鏄?惁榛樿?鍦板潃
	 */
	private Integer defaultStatus;

}
