package com.tingyu.sparkmall.lottery;


import com.tingyu.sparkmall.commons.utils.RedisKeys;
import com.tingyu.sparkmall.lottery.feign.MemberFeignService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.SetOperations;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

//@WebAppConfiguration
//@SpringBootTest
@SpringBootTest(classes = {SparkmallLotteryApplication.class})
class SparkmallLotteryApplicationTests {

    @Autowired
    private ApplicationContext context;

    @Resource
    MemberFeignService memberFeignService;
    @Autowired
    private HashOperations<String, String, Object> hashOperations;

    @Autowired
    private SetOperations<String, Object> setOperations;


    @Test
    void contextLoads() {

        String[] beanDefinitionNames = context.getBeanDefinitionNames();

        Arrays.asList(beanDefinitionNames).forEach(System.out::println);

        System.out.println("000000000000000");
    }


    @Test
    public void testSetOperation() {


        //添加
        Long add = setOperations.add(RedisKeys.RANDOM_LOTTERY_KEY, new String[]{"1", "3", "d", "2", "z", "w", "abc"});

        System.out.println("添加数据完成");

        List<Object> retValue = setOperations.pop(RedisKeys.RANDOM_LOTTERY_KEY, 2L);

        System.out.println(retValue.toString());

    }

}
