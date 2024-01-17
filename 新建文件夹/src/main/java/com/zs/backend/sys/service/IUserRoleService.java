package com.zs.backend.sys.service;

import com.zs.backend.sys.entity.UserRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author MybatisGenerator
 * @since 2020-12-13
 */
public interface IUserRoleService extends IService<UserRole> {

    /**
     * 根据userId 获取用户角色关系
     * @param userIds
     * @return
     */
    List<UserRole> getByUserIds(List<String> userIds);

}
