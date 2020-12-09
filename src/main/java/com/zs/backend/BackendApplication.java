package com.zs.backend;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.zs.backend.mapper", "com.zs.backend.test"}) //扫描的mapper
public class BackendApplication {

    private static Logger logger = LoggerFactory.getLogger(BackendApplication.class);

    public static void main(String[] args) {
        logger.warn("backend start");
        SpringApplication.run(BackendApplication.class, args);
    }

}
