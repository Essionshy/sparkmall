package com.tingyu.sparkmall.thirdparty;

import com.alibaba.fastjson.JSONObject;
import com.tingyu.sparkmall.thirdparty.utils.AlipayUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest(classes = {SparkmallThirdpartyApplication.class})
class SparkmallThirdpartyApplicationTests {

    @Autowired
    ApplicationContext context;

    @Test
    void contextLoads() {

        Map<String, Object> map = new HashMap<>();


        map.put(AlipayUtil.OUT_TRADE_NO, "109120910291");
        map.put(AlipayUtil.SUBJECT, "订单");
        map.put(AlipayUtil.PRODUCT_CODE, "109120910291");
        map.put(AlipayUtil.TOTAL_AMOUNT, "100.00");

        String content = JSONObject.toJSONString(map);

        System.out.println(content);


    }

}
