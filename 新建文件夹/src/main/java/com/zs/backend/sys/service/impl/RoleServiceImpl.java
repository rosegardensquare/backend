package com.zs.backend.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zs.backend.sys.entity.Role;
import com.zs.backend.sys.entity.RolePerm;
import com.zs.backend.sys.mapper.PermissionMapper;
import com.zs.backend.sys.mapper.RoleMapper;
import com.zs.backend.sys.mapper.RolePermMapper;
import com.zs.backend.sys.model.PermisDto;
import com.zs.backend.sys.model.RoleRes;
import com.zs.backend.sys.service.IRolePermService;
import com.zs.backend.sys.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zs.backend.user.model.PageVO;
import com.zs.backend.utils.BeanUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

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

    @Autowired
    private PermissionMapper permissionMapper;
    @Autowired
    private RolePermMapper rolePermMapper;
    @Autowired
    private IRolePermService rolePermService;


    @Override
    public PageVO<RoleRes> getRolePage(Integer pageNum, Integer pageSize, Role role) {
        IPage<Role> roleIPage = new Page<>(pageNum, pageSize);
        QueryWrapper<Role> queryWrapper = new QueryWrapper<Role>()
                .like(roleIPage != null && StringUtils.isNotBlank(role.getRoleName()),
                        Role.ROLE_NAME, role.getRoleName());

        IPage<Role> rolePage =  this.page(roleIPage, queryWrapper);
        List<RoleRes> roles =
                BeanUtil.beanCopyPropertiesForList(rolePage.getRecords(), RoleRes.class);

        List<PermisDto> permisDtos = permissionMapper.
                getByRoleIds(roles.stream().map(a -> a.getId()).collect(Collectors.toList()));
        if(permisDtos != null && !permisDtos.isEmpty()){
            Map<String, List<PermisDto>> roleIdAndMap = permisDtos
                    .stream().collect(Collectors.groupingBy(PermisDto::getRoleId));

            for(RoleRes roleRes : roles){
                if(roleIdAndMap.get(roleRes.getId()) == null || roleIdAndMap.get(roleRes.getId()).isEmpty()){
                    continue;
                }
                roleRes.setPermisIds(roleIdAndMap.get(roleRes.getId()).stream().map(a -> a.getId()).collect(Collectors.toList()));
            }
        }

        PageVO<RoleRes> vo = new PageVO(roles, rolePage.getTotal());
        return vo;
    }

    @Override
    public boolean updateRolePerm(String roleId, List<String> permIds) {
        if(permIds == null || permIds.isEmpty()){
            return true;
        }
        // 先删除
        QueryWrapper<RolePerm> queryWrapper = new QueryWrapper<RolePerm>()
                .eq(RolePerm.ROLE_ID, roleId);
        rolePermMapper.delete(queryWrapper);
        // 再新增
        List<RolePerm> rolePerms = new ArrayList<>();
        for (String permId : permIds) {
            RolePerm rolePerm = new RolePerm();
            rolePerm.setId(UUID.randomUUID().toString());
            rolePerm.setPermId(permId);
            rolePerm.setRoleId(roleId);
            rolePerms.add(rolePerm);
        }
        return rolePermService.saveBatch(rolePerms);
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public boolean deleteById(String id) {
        this.removeById(id);
        rolePermService.removeByRoleId(id);
        return true;
    }

}
