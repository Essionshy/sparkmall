package com.tingyu.sparkmall.lottery.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author essionshy
 * @Create 2020/5/8 11:41
 * @Version sparkmall
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Accessors(chain = true)
public class PrizeVO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer prizeId;
    private String prizeLevel;                 //奖项等级
    private String prizeItem;               //奖品名称
    private String twoBarCode;                 //二维码
    private Integer amount;           //奖品数量
    private Integer status;              //状态
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;       //添加时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;    //更新时间
}
