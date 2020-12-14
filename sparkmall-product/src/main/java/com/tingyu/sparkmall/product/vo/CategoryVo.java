package com.tingyu.sparkmall.product.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author essionshy
 * @Create 2020/11/29 11:49
 * @Version renren-fast
 */
@Data
public class CategoryVo implements Serializable {

    private Long id;
    /**
     * 分类名称
     */
    private String name;
    /**
     * 父分类id
     */
    private Long parentId;
    /**
     * 是否显示[0-不显示，1显示]
     */
    private Integer status;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 图标地址
     */
    private String icon;
    /**
     * 计量单位
     */
    private String unit;

    /**
     * JsonInclude 只有当不为空时，才显示些字段
     */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    List<CategoryVo> children;
}
