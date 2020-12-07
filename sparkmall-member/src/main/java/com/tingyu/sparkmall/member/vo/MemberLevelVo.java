package com.tingyu.sparkmall.member.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 会员等级实体类
 *
 * @Author essionshy
 * @Create 2020/6/16 21:26
 * @Version renren-fast
 */
@Data
public class MemberLevelVo implements Serializable {

    private Integer id;

    private String code;

    private String name;

    private String description;

    private Integer sort;

    private Integer status; //0 正常， 1 禁用

    private Integer deleted;

    List<MemberRightsVo> memberRights;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date gmtCreate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date gmtModified;
}
