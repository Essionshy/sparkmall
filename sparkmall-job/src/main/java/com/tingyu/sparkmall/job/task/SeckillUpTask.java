package com.tingyu.sparkmall.job.task;

import com.tingyu.sparkmall.job.feign.SeckillFeignService;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 秒杀上加服务
 *
 * @Author essionshy
 * @Create 2020/12/11 14:44
 * @Version renren-fast
 */
@Service
public class SeckillUpTask implements ITask {

    private final static String SECKILL_LOCK = "seckill:up:lock";
    @Resource
    private RedissonClient redissonClient;

    @Resource
    private SeckillFeignService seckillFeignService;

    @Override
    public void run(String params) {

        //分布式定时任务，需要加分布式锁，保证同一时间有且仅有一个微服务来处理业务，并保证原子性

        RLock lock = redissonClient.getLock(SECKILL_LOCK);
        try {
            //加锁
            lock.lock();
            seckillFeignService.up();
        } finally {

            if (lock.isLocked() && lock.isHeldByCurrentThread()) {
                lock.unlock();
            }
        }


    }
}
