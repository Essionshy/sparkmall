package com.tingyu.sparkmall.commons.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Author essionshy
 * @Create 2020/12/1 23:21
 * @Version renren-fast
 */
@Data
public class OrderDTO implements Serializable {

    private Long id;

    private String orderNo; //订单编号

    private String username; //用户名

    private String phone; //手机号码

    private BigDecimal totalFee; //总金额

    private Integer payType; //支付方式

    private Integer status; //订单状态

    private List<ProductDTO> products;//商品编号列表

    private BigDecimal count; //数量/重量

    private Date gmtCreate; //创建时间
}
