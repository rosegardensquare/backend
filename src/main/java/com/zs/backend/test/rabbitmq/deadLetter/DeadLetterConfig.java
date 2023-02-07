package com.zs.backend.test.rabbitmq.deadLetter;

import java.util.HashMap;
import java.util.Map;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 死信队列配置
 */
@Configuration
public class DeadLetterConfig {

    public static final String NORMAL_EXCHANGE = "normal_exchange";

    public static final String NORMAL_QUEUE = "normal_queue";

    public static final String NORMAL_ROUTING_KEY = "normal_routing_key";

    public static final String DEAD_LETTER_EXCHANGE = "dead_letter_exchange";

    public static final String DEAD_LETTER_QUEUE = "dead_letter_queue";

    public static final String DEAD_LETTER_ROUTING_KEY = "dead_letter_routing_key";

    @Bean
    public Exchange normalExchange(){
        return ExchangeBuilder.topicExchange(NORMAL_EXCHANGE).build();
    }

    @Bean
    public Queue normalQueue(){
        Map<String, Object> args = new HashMap<>();
        // 设置队列的最大长度
        args.put("x-max-length", 3);
        return QueueBuilder.nonDurable(NORMAL_QUEUE)
            .deadLetterExchange(DEAD_LETTER_EXCHANGE).deadLetterRoutingKey(DEAD_LETTER_ROUTING_KEY)
            .withArguments(args)
            .build();
    }

    @Bean
    public Binding normalBinding(Queue normalQueue, Exchange normalExchange){
        return BindingBuilder.bind(normalQueue).to(normalExchange).with(NORMAL_ROUTING_KEY).noargs();
    }

    @Bean
    public Exchange deadLetterExchange(){
        return ExchangeBuilder.topicExchange(DEAD_LETTER_EXCHANGE).build();
    }

    @Bean
    public Queue deadLetterQueue(){
        return QueueBuilder.nonDurable(DEAD_LETTER_QUEUE).build();
    }

    @Bean
    public Binding deadLetterBinding(Queue deadLetterQueue, Exchange deadLetterExchange){
        return BindingBuilder.bind(deadLetterQueue).to(deadLetterExchange).with(DEAD_LETTER_ROUTING_KEY).noargs();
    }


}
