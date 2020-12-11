package com.tingyu.sparkmall.product.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.tingyu.sparkmall.commons.support.AbstractEntity;
import lombok.Data;

/**
 * 属性分组
 * @Author essionshy
 * @Create 2020/12/8 0:22
 * @Version 
 */
@Data
@TableName(value = "tbl_attr_group")
public class AttrGroupEntity extends AbstractEntity {

    /**
     * 分组id
     */
    @TableId
    private Long attrGroupId;
    /**
     * 组名
     */
    private String attrGroupName;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 描述
     */
    private String descript;
    /**
     * 组图标
     */
    private String icon;
    /**
     * 所属分类id
     */
    private Long catelogId;

    @TableField(exist = false)
    private Long[] catelogPath;

}
