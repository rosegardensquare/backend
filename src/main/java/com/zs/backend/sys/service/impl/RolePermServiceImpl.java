package com.zs.backend.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zs.backend.sys.entity.RolePerm;
import com.zs.backend.sys.mapper.RolePermMapper;
import com.zs.backend.sys.service.IRolePermService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author MybatisGenerator
 * @since 2021-01-14
 */
@Service
public class RolePermServiceImpl extends ServiceImpl<RolePermMapper, RolePerm> implements IRolePermService {

    @Override
    public boolean removeByRoleId(String roleId) {
        return this.remove(new QueryWrapper<RolePerm>()
                .eq(RolePerm.ROLE_ID, roleId));
    }
}
