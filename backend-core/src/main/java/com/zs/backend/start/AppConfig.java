package com.zs.backend.start;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @Author Administrator
 * @Date 2025/3/28
 **/
@Configuration
@ComponentScan(basePackages = "com.zs.backend.*")  // 确保扫描到 Launcher 和其他类
public class AppConfig {
//    @Bean(initMethod = "init")
//    public SocketClientInit socketClientInit() {
//        return new SocketClientInit();
//    }
}
