package com.tingyu.sparkmall.message.config;

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

    private String exchange;

    private String create_queue;

    private String release_queue;

    private String delay_queue;

    private String create_routing_key;

    private String release_routing_key;

    private String delay_routing_key;


    /**
     * sparkmall.rabbit.order.exchange=order-event-exchange
     * sparkmall.rabbit.order.create.queue=order-create-queue
     * sparkmall.rabbit.order.release.queue=order-release-queue
     * sparkmall.rabbit.order.delay.queue=order-delay-queue
     *
     * sparkmall.rabbit.order.create.routing.key=order-create
     * sparkmall.rabbit.order.release.routing.key=order-release
     * sparkmall.rabbit.order.delay.routing.key=order-delay
     */


    private final String DEAD_LETTER_EXCHANGE_ARG = "x-dead-letter-exchange";
    private final String DEAD_LETTER_ROUTING_KEY_ARG = "x-dead-letter-routing-key";
    private final String MESSAGE_TTL_ARG = "x-message-ttl";

    public static String EXCHANGE;

    public static String CREATE_QUEUE;

    public static String RELEASE_QUEUE;

    public static String DELAY_QUEUE;

    public static String CREATE_ROUTING_KEY;

    public static String RELEASE_ROUTING_KEY;

    public static String DELAY_ROUTING_KEY;


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

        return new TopicExchange(exchange, true, false);
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
        arguments.put(DEAD_LETTER_EXCHANGE_ARG, exchange);
        arguments.put(DEAD_LETTER_ROUTING_KEY_ARG, delay_routing_key);
        arguments.put(MESSAGE_TTL_ARG, 60000);
        return new Queue(delay_queue, true, false, false, arguments);
    }

    /**
     * 订单创建队列
     * @return
     */
    @Bean
    public Queue orderCreateQueue() {

        return new Queue(create_queue, true, false, false);
    }

    /**
     * @return
     */
    @Bean
    public Queue orderReleaseQueue() {

        return new Queue(release_queue, true, false, false);
    }
    /**
     * 延时队列绑定
     * Binding(String destination, Binding.DestinationType destinationType, String exchange, String routingKey, @Nullable Map<String, Object>
     *
     * @return
     */
    @Bean
    public Binding orderDelayQueueBinding() {


        return new Binding(delay_queue, Binding.DestinationType.QUEUE, exchange, delay_routing_key, null);
    }

    /**
     * 订单关单队列绑定
     *
     * @return
     */
    @Bean
    public Binding orderReleaseQueueBinding() {


        return new Binding(release_queue, Binding.DestinationType.QUEUE, exchange, release_routing_key, null);
    }


    /**
     * 创建订单队列绑定
     * Binding(String destination, Binding.DestinationType destinationType, String exchange, String routingKey, @Nullable Map<String, Object>
     *
     * @return
     */
    @Bean
    public Binding orderCreateQueueBinding() {


        return new Binding(create_queue, Binding.DestinationType.QUEUE, exchange, create_routing_key, null);
    }




    @Override
    public void afterPropertiesSet() throws Exception {



         EXCHANGE=this.exchange;

         CREATE_QUEUE=this.create_queue;

         RELEASE_QUEUE=this.delay_queue;

         DELAY_QUEUE=this.delay_queue;

         CREATE_ROUTING_KEY=this.create_routing_key;

         RELEASE_ROUTING_KEY=this.release_routing_key;

         DELAY_ROUTING_KEY=this.delay_routing_key;

    }
}
