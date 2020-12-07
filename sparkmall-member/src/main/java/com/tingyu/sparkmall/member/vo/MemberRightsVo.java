package com.tingyu.sparkmall.member.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 会员权益展示类
 *
 * @Author essionshy
 * @Create 2020/6/17 22:21
 * @Version renren-fast
 */
@Data
public class MemberRightsVo implements Serializable {

    private Integer id;

    private String code;

    private String name;

    private String description;

    private Integer sort;

    private Integer status; //0 正常， 1 禁用

    private Boolean checked; //是否被选中

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date gmtCreate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date gmtModified;

}
