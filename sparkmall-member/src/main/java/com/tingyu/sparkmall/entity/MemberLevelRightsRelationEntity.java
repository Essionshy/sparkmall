package com.tingyu.sparkmall.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @Author essionshy
 * @Create 2020/6/17 22:26
 * @Version renren-fast
 */
@Data
@TableName("member_level_rights_relation")
public class MemberLevelRightsRelationEntity {

    private Integer id;

    private Integer levelId;

    private Integer rightsId;

    private Date createTime;

    private Date updateTime;
}
