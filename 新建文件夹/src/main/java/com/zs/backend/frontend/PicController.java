package com.zs.backend.frontend;


import com.alibaba.fastjson.JSON;
import com.zs.backend.base.Result;
import com.zs.backend.frontend.model.PicReq;
import com.zs.backend.frontend.model.PicResponse;
import com.zs.backend.frontend.model.UploadPicReq;
import com.zs.backend.frontend.service.OssService;
import com.zs.backend.mata.entity.FrontMetadata;
import com.zs.backend.mata.service.IFrontMetadataService;
import com.zs.backend.user.model.CommonUserResponse;
import com.zs.backend.user.model.PageVO;
import com.zs.backend.utils.IDGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/pic")
@Slf4j
public class PicController {

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

    @GetMapping("/getPicPage")
    public Result picPage(@RequestParam("pageNum") Integer pageNum,
                          @RequestParam("pageSize") Integer pageSize,
                          PicReq req) {
        PageVO<PicResponse> picPageVO = metadataService.getPicPage(pageNum, pageSize, req);
        return Result.result(picPageVO);
    }

}
