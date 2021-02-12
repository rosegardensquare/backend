package com.zs.backend.mata.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zs.backend.frontend.model.PicReq;
import com.zs.backend.frontend.model.PicResponse;
import com.zs.backend.mata.entity.FrontMetadata;
import com.zs.backend.mata.mapper.FrontMetadataMapper;
import com.zs.backend.mata.service.IFrontMetadataService;
import com.zs.backend.user.model.PageVO;
import com.zs.backend.utils.BeanUtil;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author MybatisGenerator
 * @since 2021-02-11
 */
@Service
public class FrontMetadataServiceImpl extends ServiceImpl<FrontMetadataMapper, FrontMetadata> implements IFrontMetadataService {

    @Override
    public PageVO<PicResponse> getPicPage(Integer pageNum, Integer pageSize, PicReq req) {
        IPage<FrontMetadata> picPage = new Page<>(pageNum, pageSize);
        QueryWrapper<FrontMetadata> queryWrapper = new QueryWrapper<FrontMetadata>()
                .eq(req.getType() != null, FrontMetadata.TYPE, req.getType())
                .orderByDesc(FrontMetadata.UPDATE_TIME);
        IPage<FrontMetadata> picIPage = this.page(picPage, queryWrapper);
        List<PicResponse> picResponses = BeanUtil.beanCopyPropertiesForList(
                picIPage.getRecords(), PicResponse.class);

        PageVO<PicResponse> picPageVO = new PageVO(picResponses, picIPage.getTotal());
        return picPageVO;
    }
}
