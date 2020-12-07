package com.tingyu.sparkmall.member.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 会员展示类
 *
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-05-11 22:03:09
 */
@Data
@Accessors(chain = true)
public class MemberVo implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    /**
     * 用户id
     */
    private String memberNo;
    /**
     * 用户名
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
     * 删除状态，0 未删除 1 删除
     */
    private Integer deleted;
    /**
     * 账号状态 0 正常，1 禁用
     */
    private Integer status;


}
