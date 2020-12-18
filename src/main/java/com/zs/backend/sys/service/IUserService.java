package com.zs.backend.sys.service;

import com.zs.backend.sys.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zs.backend.sys.model.UserReq;
import com.zs.backend.sys.model.UserResponse;
import com.zs.backend.user.model.CommonUserReq;
import com.zs.backend.user.model.CommonUserResponse;
import com.zs.backend.user.model.PageVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author MybatisGenerator
 * @since 2020-12-13
 */
public interface IUserService extends IService<User> {

    PageVO<UserResponse> getUserPage(Integer pageNum,
                                     Integer pageSize, CommonUserReq userReq);

}
