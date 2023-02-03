package com.zs.backend.config;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 声明交换机、队列、路由规则
 */
//@Configuration
public class RabbitMQConfig {

    public static final String EXCHANGE = "boot-exchange";
    public static final String QUEUE = "boot-queue";
    public static final String ROUTING_KEY = "*.black.*";

//    @Bean
//    public Exchange bootExchange(){
//        ExchangeBuilder exchangeBuilder =
//            ExchangeBuilder.directExchange("").withArgument("alternate-exchange", "");
//
//        return exchangeBuilder.build();
//    }

}
