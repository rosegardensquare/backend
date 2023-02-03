package com.zs.backend.utils.RabbitMQ.HelloWorldQueue;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.zs.backend.utils.RabbitMQ.ConnectionUtil;
import com.zs.backend.utils.RabbitMQ.RMQConstans;

public class HelloWorldQueueSender {

    public static void main(String[] args) throws Exception{

        //通过rabbitmq工具类得到连接
        Connection connection= ConnectionUtil.getConnection();
        //创建通道
        Channel channel = connection.createChannel();
        /*
         *   创建消息队列（如果有可以不用创建，但创建会覆盖之前的）
         *   第一参数：队列名称
         *   第二参数：队列是否持久化（存储到磁盘）
         *   第三参数：队列是否被独占
         *   第四参数：队列是否自动删除,当设置自动删除时，最后一个消费者解除订阅该队列时，该队列会自动删除
         *   第五参数：
         */
        channel.queueDeclare(RMQConstans.HELLO_WORLD_QUEUE_NAME, true, false, false, null);

        //创建消息
        String message="HelloWorldQueue_msg";

        /*
         *   发送消息
         *   第一参数：交换机名（简单模式不用交换机，但不能用null）
         *   第二参数：队列名称
         *   第三参数：
         *   第四参数：消息（字节流 ）
         *
         */
        for (int i = 0 ; i < 10; i ++) {
            channel.basicPublish("", RMQConstans.HELLO_WORLD_QUEUE_NAME, null, (i + 1 + " : "+  message).getBytes("UTF-8"));
        }

        System.out.println("HelloWorldQueue生产者,发送的消息："+message);

        //关闭资源
        channel.close();

        connection.close();

    }


}
