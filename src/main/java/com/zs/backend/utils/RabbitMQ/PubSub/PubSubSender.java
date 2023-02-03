package com.zs.backend.utils.RabbitMQ.PubSub;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.zs.backend.utils.RabbitMQ.ConnectionUtil;
import com.zs.backend.utils.RabbitMQ.RMQConstans;

/**
 * 发布订阅模式
 */
public class PubSubSender {

    public static void main(String[] args) throws Exception{

        Connection connection= ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        String message="PubSub_msg";
        // 声明交换机名称、类型
        channel.exchangeDeclare(RMQConstans.PUB_SUB_EXCHANGE_NAME, BuiltinExchangeType.FANOUT);
        // 构建队列1
        channel.queueDeclare(RMQConstans.PUB_SUB_QUEUE_NAME_1, false, false, false, null);
        // 构建队列2
        channel.queueDeclare(RMQConstans.PUB_SUB_QUEUE_NAME_2, false, false, false, null);
        // 绑定交换机和队列
        channel.queueBind(RMQConstans.PUB_SUB_QUEUE_NAME_1, RMQConstans.PUB_SUB_EXCHANGE_NAME,"");
        channel.queueBind(RMQConstans.PUB_SUB_QUEUE_NAME_2, RMQConstans.PUB_SUB_EXCHANGE_NAME,"");

        channel.basicPublish(RMQConstans.PUB_SUB_EXCHANGE_NAME, "",null,message.getBytes("UTF-8"));

        System.out.println("PubSub生产者,发送的消息："+ message);

        //关闭资源
        channel.close();

        connection.close();

    }


}
