package com.tingyu.sparkmall.pay.service.impl;

import com.tingyu.sparkmall.commons.dto.order.OrderDTO;
import com.tingyu.sparkmall.commons.support.MailMessage;
import com.tingyu.sparkmall.commons.support.enums.MailMessageType;
import com.tingyu.sparkmall.commons.support.enums.OrderStatus;
import com.tingyu.sparkmall.pay.feign.MessageFeignService;
import com.tingyu.sparkmall.pay.feign.OrderFeignService;
import com.tingyu.sparkmall.pay.feign.PayFeignService;
import com.tingyu.sparkmall.pay.feign.WareFeignService;
import com.tingyu.sparkmall.pay.service.PayService;
import com.tingyu.sparkmall.pay.uitls.PayType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Random;

/**
 * @Author essionshy
 * @Create 2020/12/1 23:08
 * @Version renren-fast
 */
@Slf4j
@Service
public class PayServiceImpl implements PayService {


    @Resource
    private OrderFeignService orderFeignService;

    @Resource
    private PayFeignService payFeignService;

    @Resource
    private MessageFeignService messageFeignService;

    @Resource
    private WareFeignService wareFeignService;

    @Override
    public String pay(String orderNo, Integer payType) {

        String result = "";
        //根据订单列表，计算支付总金额
        OrderDTO order = orderFeignService.getByOrderNo(orderNo);
        //根据不同的支付方式，调用对应的支付服务
        if (payType == PayType.ALIPAY.ordinal()) {
            result = alipay(order);
            log.info("返回字符串", result);
        } else if (payType == PayType.WX.ordinal()) {
            wxPay(order);
        } else {

            //默认，支付宝支付
            alipay(order);

        }


        return result;
    }

    @Override
    public void success(String orderNo) {
        //支付成功回调
        OrderDTO order = orderFeignService.getByOrderNo(orderNo);

        //修改订单状态

        orderFeignService.updateOrderStatus(orderNo, OrderStatus.PAYED.ordinal());

        //调用仓库系统，通知发货
        wareFeignService.deliver(orderNo);


        //最好是订单里面保存一个用户的邮件
        String phone = order.getPhone();


        //发送短信通知

        //支付成功，写入支付日志


        //发送邮件通知

        MailMessage message = new MailMessage();
        message.setType(MailMessageType.PAY_SUCCESS);
        message.setSubject("支付成功");
        message.setMsgId(Math.abs(new Random().nextLong()));
        message.setContent("设置支付成功后的邮件模板");
        message.setTo("1218817610@qq.com");
        messageFeignService.send(message);


    }

    /**
     * 调用微信支付
     *
     * @param order
     */
    private void wxPay(OrderDTO order) {


    }

    /**
     * 调用支付宝支付
     *
     * @param order
     */
    private String alipay(OrderDTO order) {
        //支付金额
        return payFeignService.pay(order);
    }
}
