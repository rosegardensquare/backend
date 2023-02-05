package com.zs.backend.test;

import com.zs.backend.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumeListener {

    @RabbitListener(queues = RabbitMQConfig.QUEUE)
    public void consume(String msg) {
        System.out.println("队列的消息为：" + msg);
    }
}
