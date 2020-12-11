package com.tingyu.sparkmall.coupon.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 绉掓潃鍟嗗搧閫氱煡璁㈤槄
 * 
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-12-11 16:58:02
 */
@Data
@TableName("sms_seckill_sku_notice")
public class SeckillSkuNoticeEntity implements Serializable {
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
	 * sku_id
	 */
	private Long skuId;
	/**
	 * 娲诲姩鍦烘?id
	 */
	private Long sessionId;
	/**
	 * 璁㈤槄鏃堕棿
	 */
	private Date subcribeTime;
	/**
	 * 鍙戦?鏃堕棿
	 */
	private Date sendTime;
	/**
	 * 閫氱煡鏂瑰紡[0-鐭?俊锛?-閭?欢]
	 */
	private Integer noticeType;

}
