package com.tingyu.sparkmall.lottery.listener;


import com.rabbitmq.client.Channel;
import com.tingyu.sparkmall.commons.dto.MemberDTO;
import com.tingyu.sparkmall.commons.support.enums.RecordStatusEnum;
import com.tingyu.sparkmall.lottery.dao.RecordDao;
import com.tingyu.sparkmall.lottery.entity.RecordEntity;
import com.tingyu.sparkmall.lottery.feign.MemberFeignService;
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
        log.info("rabbitmq data {}", data.toString());


        Long userId = (Long) data.get("userId");
        Integer prizeId = (Integer) data.get("prizeId");
        RecordEntity record = new RecordEntity();
        MemberDTO member = memberFeignService.getByMemberNo(userId.toString());


        if (member != null) {

            //判断是调用成功还是降级处理
            if (member.getSuccess()) {
                record.setUsername(member.getUsername());
                record.setPhone(member.getPhone());
                record.setAddress(member.getAddress());
                record.setPrizeId(prizeId);
                record.setStatus(RecordStatusEnum.CREATE.getCode());
                record.setCreatetime(new Date());
                record.setUpdatetime(new Date());
                recordDao.insert(record);

            } else {
                log.info("调用 sparkmall-member error");
            }


        }

        if (log.isDebugEnabled()) {

            log.debug("record:[{}]", record);
        }


        //获取消息ID
        Long tag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
        channel.basicAck(tag, false);//消息确认，两个参数，分别为消息ID,是否进行批量签收

        System.out.println("=======消费消息ID:=======" + tag + "=================");
    }
}

