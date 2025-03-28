package com.zs.backend.socket.tcp.common.context;


import com.zs.backend.socket.tcp.common.util.FindFile;
import io.netty.handler.ssl.ClientAuth;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextGMBuilder;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.List;

/**
 * @description: 国密SSL上下文
 * @author: Tianyun
 * @create: 2024-04-29
 **/
@Slf4j
public class GmSslContext {

    private static final String CA = "pem/gmssl/CA.cert.pem";
    private static final String SIGN_EE_CERT = "pem/gmssl/SS.cert.pem";
    private static final String SIGN_EE_KEY = "pem/gmssl/SS.key.pem";
    private static final String ENC_EE_CERT = "pem/gmssl/SE.cert.pem";
    private static final String ENC_EE_KEY = "pem/gmssl/SE.key.pem";
    private static final List<String> CIPHER_SUITE_LIST = Collections.singletonList("TLCP_SM2-WITH-SMS4-SM3");

    private static final SslContext CLIENT_SSL_CONTEXT = buildSslClientContext();
    private static final SslContext SERVER_SSL_CONTEXT = buildServerSslContext();

    private GmSslContext() {
    }

    private static final GmSslContext INSTANCE = new GmSslContext();

    public static GmSslContext getInstance() {
        return INSTANCE;
    }

    public SslContext getClientSslContext() {
        return CLIENT_SSL_CONTEXT;
    }

    public SslContext getServerSslContext() {
        return SERVER_SSL_CONTEXT;
    }

    private static SslContext buildSslClientContext() {
        String caCert = FindFile.findFile(CA);
        String encKey = FindFile.findFile(ENC_EE_KEY);
        String encCert = FindFile.findFile(ENC_EE_CERT);
        String signKey = FindFile.findFile(SIGN_EE_KEY);
        String signCert = FindFile.findFile(SIGN_EE_CERT);
        try {
            return SslContextGMBuilder.forClient().protocols()
                    .keyManagerFile(encCert, encKey, signCert, signKey, caCert)
                    .ciphers(CIPHER_SUITE_LIST)
                    .build();
        } catch (Exception e) {
            log.error("<GmSslContext>初始化失败，构建SslContext异常：", e);
        }
        return null;
    }

    public static SslContext buildServerSslContext() {
        String caCert = FindFile.findFile(CA);
        String encKey = FindFile.findFile(ENC_EE_KEY);
        String encCert = FindFile.findFile(ENC_EE_CERT);
        String signKey = FindFile.findFile(SIGN_EE_KEY);
        String signCert = FindFile.findFile(SIGN_EE_CERT);
        try {
            return SslContextGMBuilder.forServer(encCert, encKey,
                            signCert, signKey,
                            caCert).protocols()
                    .ciphers(CIPHER_SUITE_LIST)
                    .clientAuth(ClientAuth.NONE)
                    .build();
        } catch (Exception e) {
            log.error("<GmSslContext>初始化失败，构建SslContext异常：", e);
        }
        return null;
    }

    public static void main(String[] args) {
        SslContext sslCtx = GmSslContext.getInstance().getClientSslContext();
        System.out.println(sslCtx);
    }
}
