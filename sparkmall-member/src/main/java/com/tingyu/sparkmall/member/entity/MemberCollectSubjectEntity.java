package com.tingyu.sparkmall.member.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 鍏虫敞娲诲姩琛
 * 
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-12-11 16:51:21
 */
@Data
@TableName("ums_member_collect_subject")
public class MemberCollectSubjectEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * 鐢ㄦ埛id
	 */
	private Integer memberId;
	/**
	 * 娲诲姩id
	 */
	private Long subjectId;
	/**
	 * 娲诲姩鍚嶇О
	 */
	private String subjectName;
	/**
	 * 娲诲姩榛樿?鍥剧墖
	 */
	private String subjectImage;
	/**
	 * 娲诲姩閾炬帴
	 */
	private String subjectUrl;
	/**
	 * 鍏虫敞鏃堕棿
	 */
	private Date createTime;

}
