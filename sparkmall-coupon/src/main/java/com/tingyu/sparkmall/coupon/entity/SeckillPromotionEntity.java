package com.tingyu.sparkmall.coupon.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 绉掓潃娲诲姩
 * 
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-12-11 16:58:02
 */
@Data
@TableName("sms_seckill_promotion")
public class SeckillPromotionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * 娲诲姩鏍囬?
	 */
	private String title;
	/**
	 * 寮??鏃ユ湡
	 */
	private Date startTime;
	/**
	 * 缁撴潫鏃ユ湡
	 */
	private Date endTime;
	/**
	 * 涓婁笅绾跨姸鎬
	 */
	private Integer status;
	/**
	 * 鍒涘缓鏃堕棿
	 */
	private Date createTime;
	/**
	 * 鍒涘缓浜
	 */
	private Long userId;

}
