/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 * <p>
 * https://www.renren.io
 * <p>
 * 版权所有，侵权必究！
 */

package com.tingyu.sparkmall.utils;

/**
 * Redis所有Keys
 *
 * @author Mark sunlightcs@gmail.com
 */
public class RedisKeys {

    public static final String PRIZE_KEY_PREFIX = "lottery:prize:id:"; //是不是可以？保存在一个list集合中
    public static final String LOTTERY_USER_KEY_PREFIX = "lottery:user:prize:id:"; //中奖记录，放在一个set集合中呢

    public static final String LOTTER_LOCK_KEY="lottery:lock:key";


    public static final String RANDOM_LOTTERY_KEY = "lottery:random:key"; //随机抽奖，活动结束后删除该key
    public static final String REDIS_LOCK = "redis_lock"; //
}
