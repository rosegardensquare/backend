package com.zs.backend.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zs.backend.sys.entity.User;
import com.zs.backend.sys.model.UserReq;
import com.zs.backend.sys.model.UserResponse;
import com.zs.backend.user.model.CommonUserReq;
import com.zs.backend.user.model.PageVO;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author MybatisGenerator
 * @since 2020-12-13
 */
public interface IUserService extends IService<User> {

    /**
     * 分页
     *
     * @param pageNum
     * @param pageSize
     * @param userReq
     * @return
     */
    PageVO<UserResponse> getUserPage(Integer pageNum,
                                     Integer pageSize, CommonUserReq userReq);

    /**
     * 添加或更新
     *
     * @param userReq
     * @return
     */
    boolean saveOrUpdateUser(UserReq userReq);

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    boolean removeUserById(String id);
}
