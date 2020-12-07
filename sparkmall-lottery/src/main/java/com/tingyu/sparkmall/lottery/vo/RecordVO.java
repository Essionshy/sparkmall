package com.tingyu.sparkmall.lottery.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tingyu.sparkmall.lottery.entity.PrizeEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.sql.Timestamp;

/**
 * @Author essionshy
 * @Create 2020/5/9 14:05
 * @Version sparkmall
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Accessors(chain = true)
public class RecordVO {
    private static final long serialVersionUID = 1L;
    private Long recordId;
    private String username;                 //中奖人姓名
    private String phone;                  //中奖人手机号
    private String address;              //中奖人收货地址
    private PrizeEntity prize;             //奖品ID,关联奖品实体
    private Integer status;              //状态
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp createTime;       //添加时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp updateTime;    //更新时间
}
