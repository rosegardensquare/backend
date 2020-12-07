package com.zs.backend.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zs.backend.entity.User;
import com.zs.backend.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findById(int id) {
        return userMapper.findById(1);
    }
}
