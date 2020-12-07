package com.tingyu.sparkmall.member.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.tingyu.sparkmall.commons.support.AbstractEntity;
import lombok.Data;

/**
 * 会员等级与会员权益多对多关系实体类
 *
 * @Author essionshy
 * @Create 2020/6/17 22:26
 * @Version renren-fast
 */
@Data
@TableName("tbl_member_level_rights_relation")
public class MemberLevelRightsRelationEntity extends AbstractEntity {

    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    private Integer levelId;

    private Integer rightsId;


}
