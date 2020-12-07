package com.tingyu.sparkmall.commons.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 会员传输对象，用于网络传输
 *
 * @Author essionshy
 * @Create 2020/11/27 12:23
 * @Version renren-fast
 */
@Data
public class MemberDTO implements Serializable {


    private Long userId;
    /**
     * 用户名
     */
    private String username;
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
    private Integer deleteStatus;

    //服务调用状态
    private Boolean success;


}
