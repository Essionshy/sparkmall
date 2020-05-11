package com.tingyu.sparkmall;

import com.tingyu.sparkmall.feign.MemberFeignService;
import com.tingyu.sparkmall.utils.R;
import com.tingyu.sparkmall.vo.MemberVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import java.util.Arrays;

@WebAppConfiguration
@SpringBootTest
@ContextConfiguration
class SparkmallLotteryApplicationTests {

    @Autowired
    private ApplicationContext context;

    @Resource
    MemberFeignService memberFeignService;
    @Autowired
    private HashOperations<String, String, Object> hashOperations;

    @Test
    void contextLoads() {

        String[] beanDefinitionNames = context.getBeanDefinitionNames();

        Arrays.asList(beanDefinitionNames).forEach(System.out::println);

        System.out.println("000000000000000");
    }


    @Test
    public void testRabbitMQ() {
        R result = memberFeignService.info(1L);
        MemberVo member = (MemberVo) result.get("member");
    }

}
