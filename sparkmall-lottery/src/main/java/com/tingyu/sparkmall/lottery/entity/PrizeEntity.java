package com.tingyu.sparkmall.lottery.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-05-11 14:20:55
 */
@Data
@TableName("prize")
public class PrizeEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 奖品ID
     */
    @TableId(type = IdType.AUTO)
    private Integer prizeId;
    /**
     * 奖项等级
     */
    private String prizeLevel;
    /**
     * 奖品明细
     */
    private String prizeItem;
    /**
     * 抽奖二维码
     */
    private String twoBarCode;
    /**
     * 奖品数量
     */
    private Integer amount;
    /**
     * 奖品状态 0 未开始，1 进行中，2 已结束
     */
    private Integer status;
    /**
     * 抽奖开始时间
     */
    private Date starttime;
    /**
     * 抽奖结束时间
     */
    private Date endtime;
    /**
     * 创建时间
     */
    private Date createtime;
    /**
     * 更新时间
     */
    private Date updatetime;

}
