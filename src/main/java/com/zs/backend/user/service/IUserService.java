package com.zs.backend.user.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zs.backend.user.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zs.backend.user.model.PageVO;
import com.zs.backend.user.model.UserReq;
import com.zs.backend.user.model.UserResponse;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author MybatisGenerator
 * @since 2020-12-10
 */
public interface IUserService extends IService<User> {

    PageVO<UserResponse> getUserPage(Integer pageNum, Integer pageSize, UserReq userReq);

}
