package com.tingyu.sparkmall.thirdparty.properties;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author essionshy
 * @Create 2020/10/30 11:29
 * @Version tongmeng-edu
 */
@Component
public class AliyunSmsProperties implements InitializingBean {



    @Value("${spring.cloud.aliyun.sms.accessKey}")
    private String accessKey;

    @Value("${spring.cloud.aliyun.sms.keySecret}")
    private String keySecret;

    @Value("${spring.cloud.aliyun.sms.templateCode}")
    private String templateCode;
    @Value("${spring.cloud.aliyun.sms.signName}")
    private String signName;



    //定义公共访问常量

    public static String TEMPLATE_CODE;
    public static String ACCESS_KEY;
    public static String KEY_SECRET;
    public static String SIGN_NAME;
    @Override
    public void afterPropertiesSet() throws Exception {
        TEMPLATE_CODE=this.templateCode;
        ACCESS_KEY=this.accessKey;
        KEY_SECRET=this.keySecret;
        SIGN_NAME=this.signName;
    }
}
