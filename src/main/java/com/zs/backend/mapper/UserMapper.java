package com.zs.backend.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zs.backend.entity.User;
import org.springframework.stereotype.Repository;

public interface UserMapper extends BaseMapper<User> {

    User findById(int id);

}
