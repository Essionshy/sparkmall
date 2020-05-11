package com.tingyu.sparkmall.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @Author essionshy
 * @Create 2020/5/9 0:25
 * @Version sparkmall
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Accessors(chain = true)
public class MemberVo {
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
