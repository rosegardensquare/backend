package com.zs.backend.utils.RabbitMQ.Routing;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.zs.backend.utils.RabbitMQ.ConnectionUtil;
import com.zs.backend.utils.RabbitMQ.RMQConstans;

/**
 * 发布订阅模式
 */
public class RoutingSender {
    public static final String TOPIC_QUEUE_NAME_1 = "topic_queue_name_1";
    public static final String TOPIC_QUEUE_NAME_2 = "topic_queue_name_2";
    public static final String TOPIC_EXCHANGE_NAME = "topic_exchange_name";
    public static void main(String[] args) throws Exception{
        Connection connection= ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        // 声明交换机名称、类型
        channel.exchangeDeclare(TOPIC_EXCHANGE_NAME, BuiltinExchangeType.TOPIC);
        // 构建队列1
        channel.queueDeclare(TOPIC_QUEUE_NAME_1, false, false, false, null);
        // 构建队列2
        channel.queueDeclare(TOPIC_QUEUE_NAME_2, false, false, false, null);
        // 绑定交换机和队列
        channel.queueBind(TOPIC_QUEUE_NAME_1, TOPIC_EXCHANGE_NAME, "*.info.*");
        channel.queueBind(TOPIC_QUEUE_NAME_2, TOPIC_EXCHANGE_NAME, "error.#");
        // 发送消息
        channel.basicPublish(TOPIC_EXCHANGE_NAME, "a.info.a",null,"队列1的消息".getBytes());
        channel.basicPublish(TOPIC_EXCHANGE_NAME,"error.a.a",null,"队列2的消息".getBytes());
        System.out.println("topic生产者发送消息");
        //关闭资源
        channel.close();

        connection.close();
    }


}
