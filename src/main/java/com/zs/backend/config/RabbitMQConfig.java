//package com.zs.backend.config;
//
//import org.springframework.amqp.core.Binding;
//import org.springframework.amqp.core.BindingBuilder;
//import org.springframework.amqp.core.Exchange;
//import org.springframework.amqp.core.ExchangeBuilder;
//import org.springframework.amqp.core.Queue;
//import org.springframework.amqp.core.QueueBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * 声明交换机、队列、路由规则
// * 绑定队列-交换机-路由规则
// */
//@Configuration
//public class RabbitMQConfig {
//
//    public static final String EXCHANGE = "boot-exchange";
//    public static final String QUEUE = "boot-queue";
//    public static final String ROUTING_KEY = "*.black.*";
//
//    // topic 模式：创建交换机
//    @Bean
//    public Exchange topicExchange(){
//        ExchangeBuilder exchangeBuilder =
//            // 可以指定交换机类型
//            ExchangeBuilder.topicExchange(EXCHANGE);
//        return exchangeBuilder.build();
//    }
//
//    // topic 模式：创建 topic队列
//    @Bean
//    public Queue topicQueue(){
//        return QueueBuilder.nonDurable(QUEUE).build();
//    }
//
//    // topic 模式：根据路由规则，队列绑定到交换机上
//    @Bean
//    public Binding topicBind(Exchange topicExchange, Queue topicQueue){
//        return BindingBuilder.bind(topicQueue).to(topicExchange).with(ROUTING_KEY).noargs();
//    }
//
//
//
//}
