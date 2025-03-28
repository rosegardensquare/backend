package com.zs.backend.start;


import cn.hutool.core.util.StrUtil;
import com.zs.backend.socket.net.client.ConnectionVO;
import com.zs.backend.socket.net.client.SslClient;
import com.zs.backend.socket.net.client.SslClientBuilder;
import com.zs.backend.socket.net.common.statement.enums.MessageType;
import com.zs.backend.socket.net.common.statement.vo.CertVo;
import com.zs.backend.socket.net.common.statement.vo.MessageVo;
import com.zs.backend.socket.net.impl.ClientReceiver;
import java.util.Collections;
import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description cross-perf启动类
 * @Author SunYanKe
 * @Date 2024/6/28 11:36
 **/
public class App {

    private static final int SERVER_PORT = 9911;

    private static final List<String> SERVER_IPS = Collections.singletonList("192.168.51.195");


    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//        SslClientAgent sslClientAgent = context.getBean(SslClientAgent.class);
//        sslClientAgent.initialize(SslEncryptType.TCP, null);
        CertVo certVo = new CertVo()
            .setCertPath("cert/client-cert.pem")
            .setKeyPath("cert/client-cert.pem")
            .setCaPath("cert/client-cert.pem");

        ConnectionVO connectionVO = new ConnectionVO()
            .setServerIps(SERVER_IPS)       // (必填项) 服务IP集合
            .setServerPort(SERVER_PORT)     // (必填项) 服务端口
            .setCertVo(certVo)             // (选填项) 通信SSL证书，不设置则使用默认证书
            .setReceiverProcessor(ClientReceiver.getInstance());    // (选填项) 消息处理实现类，若不需要处理服务端消息，不设置即可
        connServerAndSendMsg(connectionVO, "666");


    }


    private static void connServerAndSendMsg(ConnectionVO connectionVO, String msg) {
        // 1.构建连接，返回连接成功的服务地址(格式 -> 服务IP:端口)
        String serverAddress = SslClientBuilder.getInstance().buildConnection(connectionVO);

        if (StrUtil.isNotBlank(serverAddress)) {

            // 2.获取可用连接
            SslClient sslClient = SslClientBuilder.getInstance().getSslClient(serverAddress);

            if (sslClient != null) {

                // 3.封装消息
                MessageVo messageVo = new MessageVo()
                    .setType(MessageType.CLIENT_MSG.getCode())
                    .setData(msg);

                // 4.发送消息
                // sslClient.send(JacksonUtil.toJSON(messageVo));
            }
        } else {
            System.out.println("与服务端构建SSL失败");
        }
    }
}
