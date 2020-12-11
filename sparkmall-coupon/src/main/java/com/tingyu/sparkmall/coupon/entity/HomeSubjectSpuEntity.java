package com.tingyu.sparkmall.coupon.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 涓撻?鍟嗗搧
 * 
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-12-11 16:58:02
 */
@Data
@TableName("sms_home_subject_spu")
public class HomeSubjectSpuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * 涓撻?鍚嶅瓧
	 */
	private String name;
	/**
	 * 涓撻?id
	 */
	private Long subjectId;
	/**
	 * spu_id
	 */
	private Long spuId;
	/**
	 * 鎺掑簭
	 */
	private Integer sort;

}
