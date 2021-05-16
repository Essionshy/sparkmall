package com.tingyu.sparkmall.ware.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * 库存定时解锁库存实现最终一致性
 * @Author essionshy
 * @Create 2020/12/9 0:02
 * @Version renren-fast
 */
@Configuration
public class RabbitMQConfig {

    /**
     * 配置 JSON 类型消息
     *
     * @return
     */
    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    /**
     * String name  交换机名称
     * boolean durable  交换机是否是持久的
     * boolean autoDelete 交换机是否自动删除
     *
     * @return
     */
    @Bean
    public Exchange storeEventExchange() {
        return new TopicExchange("store-event-exchange", true, false);
    }

    /**
     * 订单延时队列处理定时关单业务 【死信队列】
     * Queue(String name, boolean durable, boolean exclusive, boolean autoDelete, @Nullable Map<String, Object> arguments)
     *          配置死信队列三大参数
     *          arguments.put("x-dead-letter-exchange", "some.exchange.name");
     *         arguments.put("x-dead-letter-routing-key", "some-routing-key");
     *         arguments.put("x-message-ttl", 60000);
     * @return
     */
    @Bean
    public Queue storeDelayQueue() {
        Map<String, Object> arguments = new HashMap<>();
        arguments.put("x-dead-letter-exchange", "store-event-exchange");
        arguments.put("x-dead-letter-routing-key", "store-release");
        arguments.put("x-message-ttl", 60000);
        return new Queue("store-delay-queue", true, false, false, arguments);
    }

    /**
     *
     * @return
     */
    @Bean
    public Queue storeReleaseQueue() {
        return new Queue("store-release-queue", true, false, false);
    }

    /**
     * 延时队列绑定
     * Binding(String destination, Binding.DestinationType destinationType, String exchange, String routingKey, @Nullable Map<String, Object>
     * @return
     */
    @Bean
    public Binding storeDelayQueueBinding(){
        return new Binding("store-delay-queue", Binding.DestinationType.QUEUE,"store-event-exchange","store-locked",null);
    }

    /**
     * 库存解锁队列绑定
     * @return
     */
    @Bean
    public Binding storeReleaseQueueBinding(){
        return new Binding("store-release-queue", Binding.DestinationType.QUEUE,"store-event-exchange","store-release",null);
    }

}
