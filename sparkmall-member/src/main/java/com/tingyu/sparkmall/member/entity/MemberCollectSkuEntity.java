package com.tingyu.sparkmall.member.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 鍏虫敞鍟嗗搧琛
 * 
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-12-11 16:51:21
 */
@Data
@TableName("ums_member_collect_sku")
public class MemberCollectSkuEntity implements Serializable {
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
	 * sku_id
	 */
	private Long skuId;
	/**
	 * sku鏍囬?
	 */
	private String skuTitle;
	/**
	 * sku榛樿?鍥剧墖
	 */
	private String skuImage;
	/**
	 * 鍒涘缓鏃堕棿
	 */
	private Date createTime;

}
