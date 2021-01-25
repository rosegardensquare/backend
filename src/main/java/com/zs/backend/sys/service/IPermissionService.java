package com.zs.backend.sys.service;

import com.zs.backend.sys.entity.Permission;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zs.backend.user.model.PageVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author MybatisGenerator
 * @since 2021-01-25
 */
public interface IPermissionService extends IService<Permission> {

    PageVO<Permission> getPermissionPage(Integer pageNum,
                             Integer pageSize, Permission permission);
}
