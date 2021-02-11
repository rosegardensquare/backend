package com.zs.backend.frontend;


import com.zs.backend.base.Result;
import com.zs.backend.frontend.service.OssService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/pic")
@Slf4j
public class UploadPicController {

    @Autowired
    private OssService ossService;

    @PostMapping("/upload")
    public Result uploadPic(MultipartFile file) throws IOException {
        return Result.result(ossService.uploadFile(file));
    }

}
