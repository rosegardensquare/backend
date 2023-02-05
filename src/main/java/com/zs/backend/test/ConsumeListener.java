package com.zs.backend.test;

import com.rabbitmq.client.Channel;
import com.zs.backend.config.RabbitMQConfig;
import java.io.IOException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * ranbbitMQ 的消费者
 */
@Component
public class ConsumeListener {

    /**
     * 消费者手动 ack 方式
     * @param msg
     */
    @RabbitListener(queues = RabbitMQConfig.QUEUE)
    public void consume(String msg, Channel channel, Message message) throws IOException {
        // 获取消息的唯一标识
        String correlationId = message.getMessageProperties().getCorrelationId();
        System.out.println("消息唯一标识：" + correlationId);
        message.getMessageProperties().getDeliveryTag();
        System.out.println("队列的消息为：" + msg);
        // 使用 channel 手动设置 ack
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }


}
