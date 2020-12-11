package com.tingyu.sparkmall.order.config;

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
    public Exchange orderEventExchange() {

        return new TopicExchange("order-event-exchange", true, false);
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
    public Queue orderDelayQueue() {

        Map<String, Object> arguments = new HashMap<>();
        arguments.put("x-dead-letter-exchange", "order-event-exchange");
        arguments.put("x-dead-letter-routing-key", "order-release");
        arguments.put("x-message-ttl", 60000);
        return new Queue("order-delay-queue", true, false, false, arguments);
    }

    /**
     *
     * @return
     */
    @Bean
    public Queue orderReleaseQueue() {

        return new Queue("order-release-queue", true, false, false);
    }

    /**
     * 延时队列绑定
     * Binding(String destination, Binding.DestinationType destinationType, String exchange, String routingKey, @Nullable Map<String, Object>
     * @return
     */
    @Bean
    public Binding orderDelayQueueBinding(){


        return new Binding("order-delay-queue", Binding.DestinationType.QUEUE,"order-event-exchange","order-create",null);
    }

    /**
     * 订单关单队列绑定
     * @return
     */
    @Bean
    public Binding orderReleaseQueueBinding(){


        return new Binding("order-release-queue", Binding.DestinationType.QUEUE,"order-event-exchange","order-release",null);
    }

}
