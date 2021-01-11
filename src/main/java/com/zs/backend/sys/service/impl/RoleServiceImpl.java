package com.zs.backend.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zs.backend.sys.entity.Role;
import com.zs.backend.sys.mapper.RoleMapper;
import com.zs.backend.sys.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zs.backend.user.model.PageVO;
import com.zs.backend.utils.BeanUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author MybatisGenerator
 * @since 2020-12-13
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    @Override
    public PageVO<Role> getRolePage(Integer pageNum, Integer pageSize, Role role) {
        IPage<Role> roleIPage = new Page<>(pageNum, pageSize);
        QueryWrapper<Role> queryWrapper = new QueryWrapper<Role>()
                .like(roleIPage != null && StringUtils.isNotBlank(role.getRoleName()),
                        Role.ROLE_NAME, role.getRoleName());

        IPage<Role> rolePage =  this.page(roleIPage, queryWrapper);
        List<Role> roles =
                BeanUtil.beanCopyPropertiesForList(rolePage.getRecords(), Role.class);

        PageVO<Role> vo = new PageVO(roles, rolePage.getTotal());
        return vo;
    }
}
