package com.zs.backend.user.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zs.backend.user.entity.CommonUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zs.backend.user.model.CommonUserReq;
import com.zs.backend.user.model.CommonUserResponse;
import com.zs.backend.user.model.PageVO;

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

    void test();

}
