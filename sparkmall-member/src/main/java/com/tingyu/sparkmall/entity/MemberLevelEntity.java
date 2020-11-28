package com.tingyu.sparkmall.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author essionshy
 * @Create 2020/6/16 21:26
 * @Version renren-fast
 */
@Data
@TableName("member_level")
public class MemberLevelEntity implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private Integer code;

    private String description;

    private Date createTime;

    private Date updateTime;
}
