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

public class PubSubReciver2 {
    public static void main(String[] args) throws Exception{

        Connection connection= ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        // 绑定交换机和队列
        channel.queueBind(RMQConstans.ROUTING_QUEUE_NAME_2, RMQConstans.ROUTING_EXCHANGE_NAME,"");
        channel.basicConsume(RMQConstans.ROUTING_QUEUE_NAME_2, true,  new DefaultConsumer(channel){
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    //获取消息数据
                    String bodyStr = new String(body, "UTF-8");
                    System.out.println("routing消费者2，接收消息：  " + bodyStr);
                    try {
                        Thread.sleep(10000000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        );

    }

}
