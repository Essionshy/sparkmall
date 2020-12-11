package com.tingyu.sparkmall.commons.dto.seckill;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @Author essionshy
 * @Create 2020/12/11 21:08
 * @Version sparkmall
 */
@Data
public class SeckillSessionDTO {
    private Long id;
    /**
     * 活动名称
     */
    private String name;
    /**
     * 秒杀开始时间
     */
    private Date startTime;
    /**
     * 秒杀结束时间
     */
    private Date endTime;
    /**
     * 启用状态
     */
    private Integer status;
    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 秒杀商品明细
     */
    private List<SeckillSkuDTO> seckillItems;

}
