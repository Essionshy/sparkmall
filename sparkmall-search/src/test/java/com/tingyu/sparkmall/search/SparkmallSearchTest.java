package com.tingyu.sparkmall.search;

import org.elasticsearch.client.RestHighLevelClient;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @Author essionshy
 * @Create 2020/12/7 0:44
 * @Version renren-fast
 */

@SpringBootTest
public class SparkmallSearchTest {


    @Resource
    private RestHighLevelClient client;

    @Test
    public void testIndex() {

        System.out.println(client);

    }
}
