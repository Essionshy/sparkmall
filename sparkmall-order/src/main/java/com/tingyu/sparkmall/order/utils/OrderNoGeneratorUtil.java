package com.tingyu.sparkmall.order.utils;

import com.tingyu.sparkmall.commons.utils.SpringContextUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * @Author essionshy
 * @Create 2020/11/28 20:59
 * @Version renren-fast
 */

@Slf4j
public final class OrderNoGeneratorUtil {

    private static final String ORDER_NO_PRIFIX = "TY_";
    private static final String LOCK_KEY = "lock_key";

    private static Integer id = null;
    private static StringRedisTemplate stringRedisTemplate;

    /**
     * 生成订单号，分布式系统中订单号唯一性通过加分布式锁实现
     *
     * @return
     */
    public static String getOrderNo() {
        String result = null;

        try {
            String value = UUID.randomUUID().toString() + Thread.currentThread().getName();
            //加锁

            stringRedisTemplate = SpringContextUtils.getBean("stringRedisTemplate", StringRedisTemplate.class);


            Boolean ifAbsent = stringRedisTemplate.opsForValue().setIfAbsent(LOCK_KEY, value);


            if (!ifAbsent) {
                log.info("{}：获取锁失败...", Thread.currentThread().getName());
            }


            result = generate(); //生成订单号


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放锁,防止程序出现异常时，没有执行删除Lock的方法

            //由于删除Lock的方法不是原子的，因此执行删除操作应该使用 lua 脚本； 为了实现手动实现原子操作，可以借助 redis 的事务

            while (true) {
                stringRedisTemplate.setEnableTransactionSupport(true); //开启事务支持
                stringRedisTemplate.watch(LOCK_KEY); //监控 LOCK_KEY ，如果它的什没有变化则直接删除，如果已被修改，需要重新执行
                stringRedisTemplate.multi();
                stringRedisTemplate.delete(LOCK_KEY);
                List<Object> list = stringRedisTemplate.exec();//提交事务
                if (list == null) {
                    continue; //删除失败，继续执行，直到删除成功为止
                }
                //删除成功，则取消息监听
                stringRedisTemplate.unwatch();
                //退出当前 while 循环
                break;
            }
        }


        return result;
    }

    /**
     * 根据下单时间构建
     *
     * @return
     */
    public static String generate() {


        if (id == null) {
            id = Math.abs(new Random().nextInt(100000000));
        } else {
            id += 1;
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

        String datetime = sdf.format(new Date());

        return ORDER_NO_PRIFIX + datetime + String.valueOf(id);
    }

}
