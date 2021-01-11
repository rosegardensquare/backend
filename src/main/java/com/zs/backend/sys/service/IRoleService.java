package com.zs.backend.sys.service;

import com.zs.backend.sys.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zs.backend.sys.model.UserResponse;
import com.zs.backend.user.model.CommonUserReq;
import com.zs.backend.user.model.PageVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author MybatisGenerator
 * @since 2020-12-13
 */
public interface IRoleService extends IService<Role> {
    PageVO<Role> getRolePage(Integer pageNum,
                                     Integer pageSize, Role role);

}
