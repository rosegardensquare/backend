package com.zs.backend.sys.auth;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zs.backend.sys.entity.*;
import com.zs.backend.sys.mapper.*;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.security.Permission;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 张帅
 * @date 2020年12月15日
 * @description springsecurity 认证方法重写
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {


    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private RolePermMapper rolePermMapper;
    @Autowired
    private PermissionMapper permissionMapper;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        QueryWrapper<User> userWrapper = new QueryWrapper<User>()
                .eq(User.USER_NAME, username);
        User user = null;
        try{
            user = userMapper.selectOne(userWrapper);
        }catch (Exception e){
            e.printStackTrace();
        }

        if(user == null){
            throw new UsernameNotFoundException(String.format("用户%s", username));
        }

        QueryWrapper<UserRole> userRoleWrapper = new QueryWrapper<UserRole>()
                .eq(User.ID, user.getId());
        List<UserRole> userRoles = userRoleMapper.selectList(userRoleWrapper);
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        userRoles.forEach(roleUser->{
            // 根据 roleId 查询权限菜单
            QueryWrapper<RolePerm> rolePermiWrapper = new QueryWrapper<RolePerm>();
            rolePermiWrapper.eq(RolePerm.ROLE_ID, roleUser.getRoleId());
            List<RolePerm> rolePerms = rolePermMapper.selectList(rolePermiWrapper);
            QueryWrapper<Permis> permisQueryWrapper = new QueryWrapper<Permis>();
            permisQueryWrapper.in(Permis.ID,
                    rolePerms.stream().map(a -> a.getId()).collect(Collectors.toList()));
            List<Permis> permissions = permissionMapper.selectList(permisQueryWrapper);
            permissions.forEach(permis -> {
                authorities.add(new SimpleGrantedAuthority(permis.getPermissionName()));
            });
        });
        org.springframework.security.core.userdetails.User user1 =
                new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassWord(), authorities);
        return user1;
    }


}
