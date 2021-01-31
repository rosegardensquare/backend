package com.zs.backend.frontend;


import com.zs.backend.base.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/pic")
@Slf4j
public class UploadController {


    @PostMapping("/upload")
    public Result uploadPic(@RequestBody MultipartFile file) throws IOException {
        String filePath = "D://test";
        String fileName = UUID.randomUUID() + "."
                + file.getContentType().substring(file.getContentType().lastIndexOf("/") + 1);
        // 创建文件
        File dest = new File(filePath,fileName);
        // 文件保存
        try {
            file.transferTo(dest);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.result(true);
    }

}
