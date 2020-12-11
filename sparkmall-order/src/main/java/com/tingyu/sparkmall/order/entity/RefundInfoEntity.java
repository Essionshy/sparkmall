package com.tingyu.sparkmall.order.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 閫??淇℃伅
 * 
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-12-11 16:35:37
 */
@Data
@TableName("oms_refund_info")
public class RefundInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * 閫??鐨勮?鍗
	 */
	private Long orderReturnId;
	/**
	 * 閫??閲戦?
	 */
	private BigDecimal refund;
	/**
	 * 閫??浜ゆ槗娴佹按鍙
	 */
	private String refundSn;
	/**
	 * 閫??鐘舵?
	 */
	private Integer refundStatus;
	/**
	 * 閫??娓犻亾[1-鏀?粯瀹濓紝2-寰?俊锛?-閾惰仈锛?-姹囨?]
	 */
	private Integer refundChannel;
	/**
	 * 
	 */
	private String refundContent;

}
