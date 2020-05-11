package com.tingyu.sparkmall.product;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class SparkmallProductApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    void contextLoads() {
        System.out.println("this");

        Map<String, Object> data = new HashMap<>();
        data.put("userId", 1);
        data.put("prizeId", 2);
        rabbitTemplate.convertAndSend("exchange-lottery", null, data);

    }

}
