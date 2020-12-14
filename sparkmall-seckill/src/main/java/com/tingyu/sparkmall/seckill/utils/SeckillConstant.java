package com.tingyu.sparkmall.seckill.utils;

/**
 * @Author essionshy
 * @Create 2020/12/11 21:55
 * @Version sparkmall
 */
public final class SeckillConstant {

    public final static String SECKILL_SESSION_KEY_PREFIX="seckill:session:";
    public final static String SECKILL_SKU_KEY="seckill:skus"; // hash 保存秒杀场次对就的商品详细信息 key[sessionId_skuId]

    public static final String SECKILL_SKU_STOCK_SEMAPHORE_PREFIX = "seckill:sku:stock:token:"; //秒杀商品数量信号量 key
}
