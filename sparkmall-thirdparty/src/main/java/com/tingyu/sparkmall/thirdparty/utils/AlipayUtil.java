package com.tingyu.sparkmall.thirdparty.utils;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.tingyu.sparkmall.thirdparty.properties.AlipayProperties;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @Author essionshy
 * @Create 2020/12/2 19:55
 * @Version renren-fast
 */
public final class AlipayUtil {

    public static final String OUT_TRADE_NO = "out_trade_no";
    public static final String PRODUCT_CODE = "product_code";
    public static final String SUBJECT = "subject";
    public static final String TOTAL_AMOUNT = "total_amount";


    private static AlipayClient alipayClient =
            new DefaultAlipayClient(
                    AlipayProperties.GATEWAY_URL,
                    AlipayProperties.APP_ID,
                    AlipayProperties.PRIVATE_KEY,
                    AlipayProperties.FORMAT,
                    AlipayProperties.CHARSET,
                    AlipayProperties.PUBLIC_KEY,
                    AlipayProperties.SIGN_TYPE);

    public static String pay(Map<String, Object> bizContent) {
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest(); //创建API对应的request
        alipayRequest.setReturnUrl(AlipayProperties.RETURN_URL);
        alipayRequest.setNotifyUrl(AlipayProperties.NOTIFY_URL); //在公共参数中设置回跳和通知地址

        String form = "";
        try {

            String content = JSONObject.toJSONString(bizContent);
            alipayRequest.setBizContent(content); //填充业务参数
            form = alipayClient.pageExecute(alipayRequest).getBody();  //调用SDK生成表单

            System.out.println(form);
        } catch (Exception e) {
            e.printStackTrace();
        }


        return form;

    }

    public static void pay(Map<String, Object> bizContent, HttpServletResponse httpResponse) {
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest(); //创建API对应的request
        alipayRequest.setReturnUrl(AlipayProperties.RETURN_URL);
        alipayRequest.setNotifyUrl(AlipayProperties.NOTIFY_URL); //在公共参数中设置回跳和通知地址

        String form = "";
        try {

            String content = JSONObject.toJSONString(bizContent);
            alipayRequest.setBizContent(content); //填充业务参数
            form = alipayClient.pageExecute(alipayRequest).getBody();  //调用SDK生成表单


            System.out.println(form);


            httpResponse.setContentType("text/html;charset=" + AlipayProperties.CHARSET);
            httpResponse.getWriter().write(form); //直接将完整的表单html输出到页面
            httpResponse.getWriter().flush();
            httpResponse.getWriter().close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
