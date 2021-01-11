package com.zs.backend.sys.auth;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zs.backend.sys.entity.Role;
import com.zs.backend.sys.entity.User;
import com.zs.backend.sys.entity.UserRole;
import com.zs.backend.sys.mapper.RoleMapper;
import com.zs.backend.sys.mapper.UserMapper;
import com.zs.backend.sys.mapper.UserRoleMapper;
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
            QueryWrapper<Role> roleWrapper = new QueryWrapper<Role>();
            roleWrapper.eq(Role.PARENT_ID, roleUser.getRoleId());
            List<Role> roles = roleMapper.selectList(roleWrapper);
            roles.forEach(role -> {
                authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
            });
        });
        org.springframework.security.core.userdetails.User user1 =
                new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassWord(), authorities);
        return user1;
    }


}
