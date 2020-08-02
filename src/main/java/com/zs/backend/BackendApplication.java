package com.zs.backend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zs.backend.mapper") //扫描的mapper
public class BackendApplication {



    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

}
