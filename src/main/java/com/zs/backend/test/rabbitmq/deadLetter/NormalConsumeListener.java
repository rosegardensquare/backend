package com.zs.backend.test.rabbitmq.deadLetter;

import com.rabbitmq.client.Channel;
import java.io.IOException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


/**
 * 正常消费者拒绝消息
 */
@Component
public class NormalConsumeListener {

    @RabbitListener(queues = DeadLetterConfig.NORMAL_QUEUE)
    public void consume(String msg, Channel channel, Message message) throws IOException {
        System.out.println("测试rabbitMQ 集群。正常消费者。消费者接收消息为：" + msg);
    }

}
