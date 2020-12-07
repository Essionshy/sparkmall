package com.tingyu.sparkmall.member.param;

import lombok.Data;

/**
 * 会员等级参数封装类
 *
 * @Author essionshy
 * @Create 2020/11/29 19:07
 * @Version renren-fast
 */
@Data
public class MemberLevelParam {

    private Integer page;

    private Long limit;

    private String key; //查询关键字

    private Integer id;

    private String code;

    private String name;

    private Integer sort;

    private Integer status;

    private String description;

    private Integer[] rithsIds;


}
