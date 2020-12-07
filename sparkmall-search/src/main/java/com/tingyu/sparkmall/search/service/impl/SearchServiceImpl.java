package com.tingyu.sparkmall.search.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.tingyu.sparkmall.commons.dto.ProductDTO;
import com.tingyu.sparkmall.search.config.ESRestClientConfig;
import com.tingyu.sparkmall.search.service.SearchService;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.math.BigDecimal;

/**
 * @Author essionshy
 * @Create 2020/12/7 1:00
 * @Version renren-fast
 */
@Service
@Slf4j
public class SearchServiceImpl implements SearchService {

    @Resource
    private RestHighLevelClient client;

    @Override
    public boolean save(String content) {

        //保存数据到 ES 服务器


        try {
            IndexRequest indexRequest = new IndexRequest();
            indexRequest.id("0");// 设置ID,不指定则 ES 自动创建
            ProductDTO productDTO = new ProductDTO();
            productDTO.setName("水");
            productDTO.setPrice(new BigDecimal(2.00));
            productDTO.setCategoryId(0L);
            productDTO.setCount(200);
            productDTO.setValidityMonth(24);
            productDTO.setManufacturer("四川省成都市高新区");

            String jsonString = JSONObject.toJSONString(productDTO);
            indexRequest.source(jsonString);

            //提交请求
            client.index(indexRequest, ESRestClientConfig.COMMON_OPTIONS);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }


    }
}
