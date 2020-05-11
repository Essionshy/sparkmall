package com.tingyu.sparkmall.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-05-11 22:03:09
 */
@Data
@TableName("member")
public class MemberEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    @TableId
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
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;

}
