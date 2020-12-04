package com.zs.backend.service.user;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zs.backend.controller.test.IOrderExtendDao;
import com.zs.backend.entity.User;
import com.zs.backend.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User Sel(int id) {
        return userMapper.Sel(1);
    }
}
