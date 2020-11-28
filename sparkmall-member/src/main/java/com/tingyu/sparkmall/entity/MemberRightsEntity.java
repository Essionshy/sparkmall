package com.tingyu.sparkmall.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author essionshy
 * @Create 2020/6/17 22:21
 * @Version renren-fast
 */
@Data
@TableName("member_rights")
public class MemberRightsEntity implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String code;

    private String name;

    private String description;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

}
