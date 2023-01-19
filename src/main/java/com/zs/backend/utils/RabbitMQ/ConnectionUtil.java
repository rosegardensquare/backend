package com.zs.backend.utils.RabbitMQ;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class ConnectionUtil {

    public static Connection getConnection() throws Exception{

        //创建连接工厂

        ConnectionFactory connectionFactory=new ConnectionFactory();

        //设置参数

        connectionFactory.setHost("192.168.237.131");//主机ip

        connectionFactory.setVirtualHost("my_rabbitmq1");//虚拟主机名

        connectionFactory.setUsername("guest");//账号

        connectionFactory.setPassword("guest");//密码

        //创建连接

        Connection newConnection = connectionFactory.newConnection();

        return newConnection;

    }
}
