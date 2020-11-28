package com.tingyu.sparkmall.order;

import com.tingyu.sparkmall.order.utils.OrderNoGeneratorUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {SparkmallOrderApplication.class})
class SparkmallOrderApplicationTests {

    @Test
    void contextLoads() {
        /*String generater = OrderNoGeneratorUtil.generater();
        System.out.println(generater);*/


        String id = OrderNoGeneratorUtil.getOrderNo();
        System.out.println(id);
    }

}
