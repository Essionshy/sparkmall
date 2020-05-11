package com.tingyu.sparkmall.param;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @Author essionshy
 * @Create 2020/5/9 14:08
 * @Version sparkmall
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Accessors(chain = true)
public class RecordParam {

    private Integer page; //分页参数

    private Integer limit;//

    private Long userId;

    private Integer prizeId;

    private String username;                 //中奖人姓名
    private String phone;                  //中奖人手机号


}
