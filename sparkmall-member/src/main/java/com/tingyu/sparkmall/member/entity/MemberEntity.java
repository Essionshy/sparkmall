package com.tingyu.sparkmall.member.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 鐢ㄦ埛琛
 * 
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-12-11 16:51:21
 */
@Data
@TableName("ums_member")
public class MemberEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * 锟斤拷员锟饺硷拷id
	 */
	private Long levelId;
	/**
	 * 鐢ㄦ埛鍚
	 */
	private String membername;
	/**
	 * 瀵嗙爜
	 */
	private String password;
	/**
	 * 鐩
	 */
	private String salt;
	/**
	 * 鏄电О
	 */
	private String nickname;
	/**
	 * 鎵嬫満鍙
	 */
	private String phone;
	/**
	 * 閭??
	 */
	private String email;
	/**
	 * 澶村儚
	 */
	private String header;
	/**
	 * 鎬у埆
	 */
	private Integer gender;
	/**
	 * 鐢熸棩
	 */
	private Date birthday;
	/**
	 * 鍩庡競
	 */
	private String city;
	/**
	 * 鑱屼笟
	 */
	private String job;
	/**
	 * 涓??绛惧悕
	 */
	private String sign;
	/**
	 * 鏉ユ簮
	 */
	private Integer sourceType;
	/**
	 * 璐?墿绉?垎
	 */
	private Integer integration;
	/**
	 * 璧犻?绉?垎
	 */
	private Integer growth;
	/**
	 * 鐘舵?
	 */
	private Integer status;
	/**
	 * 娉ㄥ唽鏃堕棿
	 */
	private Date createTime;

}
