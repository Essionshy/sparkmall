package com.tingyu.sparkmall.msg.config;

import lombok.Data;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author essionshy
 * @Create 2020/12/11 11:10
 * @Version renren-fast
 */


@ConfigurationProperties(prefix = "sparkmall.rabbit.order")
@Configuration
@Data
public class OrderRabbitConfig implements InitializingBean {

    private String exchange_name;

    private String dead_queue;

    private String consumer_queue;

    private String dead_routing_key;

    private String consumer_routing_key;

    private final String DEAD_LETTER_EXCHANGE_ARG = "x-dead-letter-exchange";
    private final String DEAD_LETTER_ROUTING_KEY_ARG = "x-dead-letter-routing-key";
    private final String MESSAGE_TTL_ARG = "x-message-ttl";

    public static String EXCHANGE_NAME;
    public static String DEAD_QUEUE;
    public static String CONSUMER_QUEUE;
    public static String DEAD_ROUTING_KEY;
    public static String CONSUMER_ROUTING_KEY;


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

        return new TopicExchange(exchange_name, true, false);
    }

    /**
     * 订单延时队列处理定时关单业务 【死信队列】
     * Queue(String name, boolean durable, boolean exclusive, boolean autoDelete, @Nullable Map<String, Object> arguments)
     * 配置死信队列三大参数
     * arguments.put("x-dead-letter-exchange", "some.exchange.name");
     * arguments.put("x-dead-letter-routing-key", "some-routing-key");
     * arguments.put("x-message-ttl", 60000);
     *
     * @return
     */
    @Bean
    public Queue orderDelayQueue() {

        Map<String, Object> arguments = new HashMap<>();
        arguments.put(DEAD_LETTER_EXCHANGE_ARG, exchange_name);
        arguments.put(DEAD_LETTER_ROUTING_KEY_ARG, dead_routing_key);
        arguments.put(MESSAGE_TTL_ARG, 60000);
        return new Queue(dead_queue, true, false, false, arguments);
    }

    /**
     * @return
     */
    @Bean
    public Queue orderReleaseQueue() {

        return new Queue(consumer_queue, true, false, false);
    }

    /**
     * 延时队列绑定
     * Binding(String destination, Binding.DestinationType destinationType, String exchange, String routingKey, @Nullable Map<String, Object>
     *
     * @return
     */
    @Bean
    public Binding orderDelayQueueBinding() {


        return new Binding(dead_queue, Binding.DestinationType.QUEUE, exchange_name, dead_routing_key, null);
    }

    /**
     * 订单关单队列绑定
     *
     * @return
     */
    @Bean
    public Binding orderReleaseQueueBinding() {


        return new Binding(consumer_queue, Binding.DestinationType.QUEUE, exchange_name, consumer_routing_key, null);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        EXCHANGE_NAME = this.exchange_name;
        DEAD_QUEUE = this.dead_queue;
        CONSUMER_QUEUE = this.consumer_queue;
        DEAD_ROUTING_KEY = this.dead_routing_key;
        CONSUMER_ROUTING_KEY = this.consumer_routing_key;
    }
}
