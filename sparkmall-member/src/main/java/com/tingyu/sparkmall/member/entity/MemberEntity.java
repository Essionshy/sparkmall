package com.tingyu.sparkmall.member.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.tingyu.sparkmall.commons.support.AbstractEntity;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 会员实体类
 *
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-05-11 22:03:09
 */
@Data
@Accessors(chain = true)
@TableName("tbl_member")
public class MemberEntity extends AbstractEntity {

    /**
     * 用户id
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    /**
     * 会员号
     */
    private String memberNo;
    /**
     * 会员名称
     */
    private String name;
    /**
     * 手机号码
     */
    private String phone;
    /**
     * 会员等级id
     */
    private Integer levelId;
    /**
     * 联系地址
     */
    private String address;
    /**
     * 是否审核 1审核通过 0审核中
     */
    private Integer audit;
    /**
     * 电子邮箱
     */
    private String email;
    /**
     * 状态 0 正常，1 禁用
     */
    private Integer status;

    /**
     * 删除状态，0 未删除 1 删除
     */
    private Integer deleted;


}
