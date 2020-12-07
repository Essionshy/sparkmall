package com.tingyu.sparkmall.member.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 会员等级与会员权益多对多关系展示类
 *
 * @Author essionshy
 * @Create 2020/6/17 22:26
 * @Version renren-fast
 */
@Data
public class MemberLevelRightsRelationVo implements Serializable {

    private Integer id;

    private Integer levelId;

    private Integer rightsId;

}
