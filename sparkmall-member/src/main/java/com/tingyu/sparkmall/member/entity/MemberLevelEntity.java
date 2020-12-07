package com.tingyu.sparkmall.member.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.tingyu.sparkmall.commons.support.AbstractEntity;
import lombok.Data;

/**
 * 会员等级实体类
 *
 * @Author essionshy
 * @Create 2020/6/16 21:26
 * @Version renren-fast
 */
@Data
@TableName("tbl_member_level")
public class MemberLevelEntity extends AbstractEntity {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String code;

    private String name;

    private Integer sort;

    private Integer deleted;

    private Integer status; //0 正常， 1 禁用

    private String description;


}
