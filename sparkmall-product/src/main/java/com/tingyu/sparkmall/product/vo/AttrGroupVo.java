package com.tingyu.sparkmall.product.vo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 属性分组
 * 
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-12-13 14:23:41
 */
@Data
@TableName("pms_attr_group")
public class AttrGroupVo implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 分组id
	 */
	private Long id;
	/**
	 * 组名
	 */
	private String name;
	/**
	 * 排序
	 */
	private Integer sort;
	/**
	 * 组图标
	 */
	private String icon;
	/**
	 * 所属分类id
	 */
	private Long categoryId;
	/**
	 * 备注
	 */
	private String remark;

	/**
	 * 回显级联选择器的分类信息
	 */
	private Long[] categoryPath;

}
