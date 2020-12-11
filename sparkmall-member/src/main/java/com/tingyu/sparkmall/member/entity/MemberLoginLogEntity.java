package com.tingyu.sparkmall.member.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 鐢ㄦ埛鐧婚檰璁板綍琛
 * 
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-12-11 16:51:21
 */
@Data
@TableName("ums_member_login_log")
public class MemberLoginLogEntity implements Serializable {
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
	 * 鐧婚檰鏃堕棿
	 */
	private Date createTime;
	/**
	 * 鐧诲綍ip
	 */
	private String ip;
	/**
	 * 鐧诲綍鍩庡競
	 */
	private String city;
	/**
	 * 鐧诲綍绫诲瀷銆?-web锛?-绉诲姩銆
	 */
	private Integer type;

}
