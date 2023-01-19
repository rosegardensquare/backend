package com.zs.backend.utils.RabbitMQ;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class Send {

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

         *   第五参数：

         */

        channel.queueDeclare("test_simple_queue", false, false, false, null);

        //创建消息

        String message="simple_queue";

        /*

         *   发送消息

         *   第一参数：交换机名（简单模式不用交换机，但不能用null）

         *   第二参数：队列名称

         *   第三参数：

         *   第四参数：消息（字节流）

         *

         */

        channel.basicPublish("", "test_simple_queue", null, message.getBytes());

        System.out.println("发送的消息："+message);

        //关闭资源

        channel.close();

        connection.close();

    }


}
