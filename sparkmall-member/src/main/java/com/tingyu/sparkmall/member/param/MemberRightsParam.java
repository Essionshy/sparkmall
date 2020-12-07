package com.tingyu.sparkmall.member.param;

import lombok.Data;

/**
 * @Author essionshy
 * @Create 2020/11/29 19:51
 * @Version renren-fast
 */
@Data
public class MemberRightsParam {

    private Integer page;

    private Long limit;

    private String key; //查询关键字

    private Integer id;

    private String code;

    private String name;

    private Integer sort;

    private Integer status;

    private String description;

}
