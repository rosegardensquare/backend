package com.zs.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zs.backend.model.dto.user.CommonUserReq;
import com.zs.backend.model.dto.user.CommonUserResponse;
import com.zs.backend.model.dto.user.PageVO;
import com.zs.backend.model.entity.user.CommonUser;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author MybatisGenerator
 * @since 2020-12-10
 */
public interface ICommonUserService extends IService<CommonUser> {

    PageVO<CommonUserResponse> getUserPage(Integer pageNum,
        Integer pageSize, CommonUserReq userReq);

}
