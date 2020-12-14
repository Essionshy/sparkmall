package com.tingyu.sparkmall.message.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-12-14 10:24:45
 */
@Data
@TableName("t_message_log")
public class MessageLogEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	@TableId(type = IdType.AUTO)
	private Long id;
	/**
	 * 消息ID
	 */
	private String msgId;
	/**
	 * 交换机名称
	 */
	private String exchangeName;
	/**
	 * 路由键
	 */
	private String routingKey;
	/**
	 * 目的地名称
	 */
	private String destination;
	/**
	 * 目的地类型
	 */
	private Integer destinationType;
	/**
	 * 消息内容
	 */
	private String content;
	/**
	 * 消息状态
	 */
	private Integer status;
	/**
	 * 创建时间
	 */
	private Date createTime;

}
