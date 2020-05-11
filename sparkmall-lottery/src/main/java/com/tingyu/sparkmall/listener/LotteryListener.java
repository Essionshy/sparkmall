package com.tingyu.sparkmall.listener;


import com.rabbitmq.client.Channel;
import com.tingyu.sparkmall.dao.RecordDao;
import com.tingyu.sparkmall.entity.RecordEntity;
import com.tingyu.sparkmall.feign.MemberFeignService;
import com.tingyu.sparkmall.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

/**
 * @Author essionshy
 * @Create 2020/5/9 21:22
 * @Version sparkmall
 */
@Slf4j
@Service
public class LotteryListener {


    @Resource
    MemberFeignService memberFeignService;
    @Resource
    RecordDao recordDao;

    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = "queue-lottery"),
            exchange = @Exchange(value = "exchange-lottery", type = "fanout")))
    @RabbitHandler
    public void handleMessage(@Payload Map data, Channel channel, @Headers Map<String, Object> headers) throws IOException {


        //模拟网络延迟
        /*try {
            TimeUnit.SECONDS.sleep(5L);} catch (InterruptedException e) { e.printStackTrace();}
    */    //
        Long userId = (Long) data.get("userId");
        Integer prizeId = (Integer) data.get("prizeId");
        RecordEntity record = new RecordEntity();
        R result = memberFeignService.info(userId);
        log.info("{}", result);
        Map member = (Map) result.get("member");
        if (member != null) {
            record.setUsername((String) member.get("username"));
            record.setPhone((String) member.get("phone"));
            record.setAddress((String) member.get("address"));
            record.setPrizeId(prizeId);
            record.setCreatetime(new Date());
        }

        recordDao.insert(record);
        //获取消息ID
        Long tag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
        channel.basicAck(tag, false);//消息确认，两个参数，分别为消息ID,是否进行批量签收

        System.out.println("=======消费消息ID:=======" + tag + "=================");
    }
}

