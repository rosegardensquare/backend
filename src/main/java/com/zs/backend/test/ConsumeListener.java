package com.zs.backend.test;

import com.rabbitmq.client.Channel;
import com.zs.backend.config.RabbitMQConfig;
import java.io.IOException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumeListener {

    @RabbitListener(queues = RabbitMQConfig.QUEUE)
    public void consume(String msg) throws IOException {
        System.out.println("队列的消息为：" + msg);
//        String correlationId = message.getMessageProperties().getCorrelationId();
//        System.out.println("唯一标识为：" + correlationId);
//        channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
    }
}
