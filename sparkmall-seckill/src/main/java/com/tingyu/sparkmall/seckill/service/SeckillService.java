package com.tingyu.sparkmall.seckill.service;

import com.tingyu.sparkmall.seckill.vo.SeckillSkuRedisVo;

import java.util.List;

/**
 * 秒杀服务
 * @Author essionshy
 * @Create 2020/12/11 14:56
 * @Version renren-fast
 */


public interface SeckillService {
    void up();

    /**
     * 返回当前秒杀场次商品列表
     * @return
     */
    List<SeckillSkuRedisVo> listCurrentSeckillSessionSkus();

    /**
     * 秒杀商品，秒杀成功返回订单号
     * @param killId
     * @param accessToken
     * @param num
     * @return
     */
    String seckill(String killId, String accessToken, Integer num) throws Exception;

}
