package com.zs.backend.sys.service;

import com.zs.backend.sys.entity.RolePerm;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author MybatisGenerator
 * @since 2021-01-14
 */
public interface IRolePermService extends IService<RolePerm> {

    /**
     * 删除角色权限关系
     * @param roleId
     * @return
     */
    boolean removeByRoleId(String roleId);
}
