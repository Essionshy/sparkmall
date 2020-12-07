package com.tingyu.sparkmall.product.param;

import lombok.Data;

/**
 * @Author essionshy
 * @Create 2020/11/29 12:11
 * @Version renren-fast
 */
@Data
public class CategoryParam {

    private Integer page;

    private Long limit;

    private Long id;

    private String name;


}
