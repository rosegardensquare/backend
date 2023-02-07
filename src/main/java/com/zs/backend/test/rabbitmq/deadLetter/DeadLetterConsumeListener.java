package com.zs.backend.test.rabbitmq.deadLetter;

import com.rabbitmq.client.Channel;
import java.io.IOException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


/**
 * 消费死信队列的消费者
 */
@Component
public class DeadLetterConsumeListener {

    @RabbitListener(queues = DeadLetterConfig.DEAD_LETTER_QUEUE)
    public void consume(String msg, Channel channel, Message message) throws IOException {
        System.out.println("测试死信队列。死信消费者。消费死信队列的消费者接收消息为：" + msg);

        // 手动 ack ,因为开启了手动 ack 模式，因此，需要手动ack; 否则，消息会一直放在队列中
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }

}
