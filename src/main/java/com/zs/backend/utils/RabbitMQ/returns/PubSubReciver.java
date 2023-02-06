package com.zs.backend.utils.RabbitMQ.returns;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import com.zs.backend.utils.RabbitMQ.ConnectionUtil;
import com.zs.backend.utils.RabbitMQ.RMQConstans;
import java.io.IOException;

public class PubSubReciver {
    public static void main(String[] args) throws Exception{

        Connection connection= ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        DefaultConsumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String bodyStr = new String(body, "UTF-8");
                System.out.println("routing消费者1，接收消息：  " + bodyStr);
            }
        };

        /**
         * 第二个参数标识是否手动确认， true:自动确认；false:手动确认
         */
        channel.basicConsume(RMQConstans.PUB_SUB_QUEUE_NAME_1, true,  consumer);

    }

}
