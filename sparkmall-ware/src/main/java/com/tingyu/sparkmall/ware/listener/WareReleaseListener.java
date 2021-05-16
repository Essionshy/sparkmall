package com.tingyu.sparkmall.ware.listener;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

/**
 * 库存解锁
 * @Author essionshy
 * @Create 2020/12/9 1:30
 * @Version renren-fast
 */
@RabbitListener(queues = "store-release-queue")
@Component
@Slf4j
public class WareReleaseListener {

    @RabbitHandler
    public void handleStockLockRelease(Map<String, Object> data, Channel channel, Message message) throws IOException {

        long tag = message.getMessageProperties().getDeliveryTag();

        try {
            log.info("data:{}", data);

            channel.basicAck(tag, false);
        } catch (Exception e) {
            //拒绝签收消息，true 表示返回到消息队列，false 表示 rabbitmq 直接将消息丢弃
           channel.basicReject(tag,true);
        }


    }

}
