package com.tingyu.sparkmall.product.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author essionshy
 * @Create 2020/11/29 11:49
 * @Version renren-fast
 */
@Data
public class CategoryVo implements Serializable {

    private Long id; //商品类别ID

    private String name; //商品类别名称


    private Date gmtCreate;


    private Date gmtModified;
}
