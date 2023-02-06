package com.zs.backend.utils.RabbitMQ.PubSub;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.BuiltinExchangeType;
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
                System.out.println("消息的回调方法" + envelope.getDeliveryTag());
                /**
                 * 第一个参数：消息的唯一id
                 * 第二个参数：是否批量确认,为 true:标识小于该条消息id 的消息都会被一起确认
                 */
                channel.basicAck(envelope.getDeliveryTag(), false);
                //channel.basicReject(envelope.getDeliveryTag(), false);
                //获取消息数据
                String bodyStr = new String(body, "UTF-8");
                System.out.println("routing消费者1，接收消息：  " + bodyStr);
            }
        };

        /**
         * 第二个参数标识是否手动确认， true:自动确认；false:手动确认
         */
        channel.basicConsume(RMQConstans.PUB_SUB_QUEUE_NAME_1, false,  consumer);

    }

}