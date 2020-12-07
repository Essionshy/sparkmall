package com.tingyu.sparkmall.thirdparty.properties;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author essionshy
 * @Create 2020/12/2 19:50
 * @Version renren-fast
 */
@Component
public class AlipayProperties implements InitializingBean {

    @Value("${alipay.app_id}")
    private String app_id;
    @Value("${alipay.gateway_url}")
    private String gateway_url;
    @Value("${alipay.private_key}")
    private String private_key;
    @Value("${alipay.public_key}")
    private String public_key;
    @Value("${alipay.charset}")
    private String charset;
    @Value("${alipay.return_url}")
    private String return_url;
    @Value("${alipay.notify_url}")
    private String notify_url;
    @Value("${alipay.format}")
    private String format;
    @Value("${alipay.sign_type}")
    private String sign_type;

    //沙箱配置
    @Value("${alipay.product_no}")
    private String product_no;


    public static String APP_ID;
    public static String GATEWAY_URL;
    public static String PRIVATE_KEY;
    public static String PUBLIC_KEY;
    public static String RETURN_URL;
    public static String NOTIFY_URL;
    public static String FORMAT;
    public static String CHARSET;
    public static String SIGN_TYPE;
    public static String PRODUCT_NO;


    @Override
    public void afterPropertiesSet() throws Exception {
        APP_ID = this.app_id;
        GATEWAY_URL = this.gateway_url;
        PRIVATE_KEY = this.private_key;
        PUBLIC_KEY = this.public_key;
        RETURN_URL = this.return_url;
        NOTIFY_URL = this.notify_url;
        FORMAT = this.format;
        CHARSET = this.charset;
        SIGN_TYPE = this.sign_type;
        PRODUCT_NO = this.product_no;
    }
}
