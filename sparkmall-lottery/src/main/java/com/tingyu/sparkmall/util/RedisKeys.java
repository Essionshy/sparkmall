package com.tingyu.sparkmall.util;

/**
 * @Author essionshy
 * @Create 2020/5/8 12:41
 * @Version sparkmall
 */
public class RedisKeys {

    public static final String PRIZE_KEY_PREFIX = "lottery:prize:id:"; //是不是可以？保存在一个list集合中
    public static final String LOTTERY_USER_KEY_PREFIX = "lottery:user:prize:id:"; //中奖记录，放在一个set集合中呢
}
