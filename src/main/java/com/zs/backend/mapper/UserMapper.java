package com.zs.backend.mapper;


import com.zs.backend.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    User Sel(int id);

}
