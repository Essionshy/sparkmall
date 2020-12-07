package com.tingyu.sparkmall.order.param;

import com.tingyu.sparkmall.commons.dto.ProductDTO;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * 订单参数，接收前端传递过来的订单参数
 *
 * @Author essionshy
 * @Create 2020/11/27 22:24
 * @Version renren-fast
 */
@Data
public class OrderParam {


    private String memberNo; //会员号

    private String phone; //手机号码

    private Integer totalCount; //订单商品总件数

    private BigDecimal totalFee; //订单总金额

    private List<ProductDTO> products; //订单商品


}
