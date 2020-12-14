package com.tingyu.sparkmall.message.config;

import com.tingyu.sparkmall.message.service.MessageLogService;
import com.tingyu.sparkmall.message.utils.MessageStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @Author essionshy
 * @Create 2020/12/3 13:20
 * @Version renren-fast
 */
@Configuration
@Slf4j
public class AppConfig {

    @Resource
    private RabbitTemplate rabbitTemplate;

    @Resource
    private MessageLogService messageLogService;

    @PostConstruct
    public void initRabbitTemplate(){

        /**
         * 设置发送端消息是否抵达 MQ 服务器确认回调
         */
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            @Override
            public void confirm(CorrelationData correlationData, boolean b, String s) {
                log.info("消息抵达MQ服务器确认: {}",correlationData);

                if(!b){
                    //消息未抵达服务器，则修改消息状态
                    messageLogService.updateMessageStatus(correlationData.getId(), MessageStatusEnum.TO_SERVER_ERROR.getCode());
                }

            }
        });

        /**
         * 设置消息是否成功抵达队列确认回调
         */
        rabbitTemplate.setReturnCallback(new RabbitTemplate.ReturnCallback() {

            /**
             *
             * @param message  消息
             * @param i
             * @param s  错误原因
             * @param s1 交换机名称
             * @param s2 路由键名称
             */
            @Override
            public void returnedMessage(Message message, int i, String s, String s1, String s2) {
                //只返回未成功抵达队列的消息，才触法该回调方法
                log.info("消息抵达队列回调：message==>{},i===>{},s ===> {},s1===>{},s2===>{}",message,i,s,s1,s2);

                String correlationId = (String) message.getMessageProperties().getHeaders().get("spring_returned_message_correlation");
                messageLogService.updateMessageStatus(correlationId, MessageStatusEnum.TO_SERVER_ERROR.getCode());
            }
        });
    }


}
