package com.zs.backend.frontend;


import com.zs.backend.base.Result;
import com.zs.backend.frontend.model.UploadPicReq;
import com.zs.backend.frontend.service.OssService;
import com.zs.backend.mata.entity.FrontMetadata;
import com.zs.backend.mata.service.IFrontMetadataService;
import com.zs.backend.utils.IDGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/pic")
@Slf4j
public class UploadPicController {

    @Autowired
    private OssService ossService;

    @Autowired
    private IFrontMetadataService metadataService;

    @PostMapping("/upload")
    public Result uploadPic(MultipartFile file) {
        return Result.result(ossService.uploadFile(file));
    }

    @PostMapping("/addPic")
    public Result addPic(@RequestBody UploadPicReq pic) {
        FrontMetadata metadata = new FrontMetadata();
        metadata.setType(Integer.parseInt(pic.getPicType()));
        metadata.setMetavalue(pic.getPicUrl());
        metadata.setId(IDGenerator.uuid());
        metadataService.save(metadata);
        return Result.result(true);
    }

}
