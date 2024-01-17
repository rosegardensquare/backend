package com.zs.backend.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zs.backend.sys.entity.UserRole;
import com.zs.backend.sys.mapper.UserRoleMapper;
import com.zs.backend.sys.service.IUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author MybatisGenerator
 * @since 2020-12-13
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public List<UserRole> getByUserIds(List<String> userIds) {
        if (userIds == null || userIds.isEmpty()) {
            return null;
        }
        return userRoleMapper.selectByUserIds(userIds);
    }


}
