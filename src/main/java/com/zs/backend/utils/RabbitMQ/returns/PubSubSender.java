package com.zs.backend.utils.RabbitMQ.returns;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConfirmCallback;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ReturnListener;
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
//        // 声明交换机名称、类型
        channel.exchangeDeclare("pub_sub_exchange_name", BuiltinExchangeType.TOPIC);
//        // 构建队列1
        channel.queueDeclare("pub_sub_queue_name_1", false, false, false, null);
//        // 绑定交换机和队列
        channel.queueBind("pub_sub_queue_name_1", "pub_sub_exchange_name","info");

        channel.queueDeclare("pub_sub_queue_name_1", false, false, false, null);



        channel.addReturnListener(new ReturnListener() {
            @Override
            public void handleReturn(int i, String s, String s1, String s2, BasicProperties basicProperties, byte[] bytes){
                System.out.println("消息没有路由到指定队列");
            }

        });
        // 第三个参数为 true 时，标识开启 return 机制
        channel.basicPublish("pub_sub_exchange_name", "error",
            true,null,
            message.getBytes("UTF-8"));

        System.out.println("PubSub生产者,发送的消息："+ message);

        //关闭资源

        channel.close();

        connection.close();

    }


}
