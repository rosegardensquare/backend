package com.zs.backend.socket.tcp.common.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;


/**
 * @author zhanghua
 */
@Slf4j
public class FindFile {

    public static String findFile(String path) {
        ClassPathResource resource = new ClassPathResource(path);
        File file = null;
        try {
            file = resource.getFile();
        } catch (IOException e) {
            log.error("获取文件路径错误,请检查文件是否存在以及路径配置：", e);
            throw new RuntimeException(e);
        }
        return file.toPath().toAbsolutePath().toString();
    }
}