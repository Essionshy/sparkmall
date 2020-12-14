package com.tingyu.sparkmall.member.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户表
 * 
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-12-13 14:22:54
 */
@Data
@TableName("ums_member")
public class MemberEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId(type = IdType.AUTO)
	private Long id;
	/**
	 * 会员等级id
	 */
	private Long levelId;
	/**
	 * 用户名
	 */
	private String membername;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 盐
	 */
	private String salt;
	/**
	 * 昵称
	 */
	private String nickname;
	/**
	 * 手机号
	 */
	private String phone;
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 头像
	 */
	private String header;
	/**
	 * 性别
	 */
	private Integer gender;
	/**
	 * 生日
	 */
	private Date birthday;
	/**
	 * 城市
	 */
	private String city;
	/**
	 * 职业
	 */
	private String job;
	/**
	 * 个性签名
	 */
	private String sign;
	/**
	 * 来源
	 */
	private Integer sourceType;
	/**
	 * 购物积分
	 */
	private Integer integration;
	/**
	 * 赠送积分
	 */
	private Integer growth;
	/**
	 * 状态
	 */
	private Integer status;
	/**
	 * 注册时间
	 */
	private Date createTime;

}
