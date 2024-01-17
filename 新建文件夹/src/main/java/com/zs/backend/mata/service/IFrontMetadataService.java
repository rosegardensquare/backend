package com.zs.backend.mata.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zs.backend.frontend.model.PicReq;
import com.zs.backend.frontend.model.PicResponse;
import com.zs.backend.mata.entity.FrontMetadata;
import com.zs.backend.user.model.PageVO;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author MybatisGenerator
 * @since 2021-02-11
 */
public interface IFrontMetadataService extends IService<FrontMetadata> {

    PageVO<PicResponse> getPicPage(Integer pageNum, Integer pageSize, PicReq req);
}
