package com.zs.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zs.backend.entity.User;
import com.zs.backend.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public interface UserService extends IService<User> {

    User findById(int id);


}
