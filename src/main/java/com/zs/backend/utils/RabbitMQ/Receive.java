package com.zs.backend.utils.RabbitMQ;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Delivery;
import com.rabbitmq.client.Envelope;
import java.io.IOException;


public class Receive {
    public static void main(String[] args) throws Exception{

        //通过rabbitmq工具类得到连接

        Connection connection=ConnectionUtil.getConnection();

        //创建通道

        Channel channel = connection.createChannel();

        /*

         *   创建消息队列（如果有可以不用创建，但创建会覆盖之前的）

         *   第一参数：队列名称

         *   第二参数：队列是否持久化（存储到磁盘）

         *   第三参数：队列是否被独占

         *   第四参数：队列是否自动删除

         *   第五参数：test_simple_queue

         */

        channel.basicConsume("test_simple_queue", true, "", new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag,
                Envelope envelope,
                AMQP.BasicProperties properties,
                byte[] body) throws IOException {
                //获取消息数据
                String bodyStr = new String(body, "UTF-8");
                System.out.println("消费者--  "+bodyStr);
            }
        });

        channel.close();
    }


}
