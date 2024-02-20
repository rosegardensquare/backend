package com.zs.backend.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zs.backend.model.dto.user.CommonUserReq;
import com.zs.backend.model.dto.user.CommonUserResponse;
import com.zs.backend.model.dto.user.PageVO;
import com.zs.backend.model.entity.user.CommonUser;
import com.zs.backend.model.mapper.user.CommonUserMapper;
import com.zs.backend.service.ICommonUserService;
import com.zs.backend.utils.BeanUtil;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>x
 *
 * @author MybatisGenerator
 * @since 2020-12-10
 */
@Service
public class CommonUserServiceImpl extends
    ServiceImpl<CommonUserMapper, CommonUser> implements ICommonUserService {

    @Override
    public PageVO<CommonUserResponse> getUserPage(Integer pageNum,
        Integer pageSize, CommonUserReq userReq) {


        IPage<CommonUser> userPage = new Page<>(pageNum, pageSize);
        QueryWrapper<CommonUser> queryWrapper = new QueryWrapper<CommonUser>()
//            .likeRight(userPage != null && StringUtils.isNotBlank(userReq.getQueryName()),
//                CommonUser.NAME, userReq.getQueryName())
            .orderByDesc(CommonUser.UPDATE_TIME);
        IPage<CommonUser> userIPage = this.page(userPage, queryWrapper);
        List<CommonUserResponse> userResponses = BeanUtil.beanCopyPropertiesForList(userIPage.getRecords(), CommonUserResponse.class);

        PageVO<CommonUserResponse> userPageVO = new PageVO(userResponses, userIPage.getTotal());
        return userPageVO;
    }
}
