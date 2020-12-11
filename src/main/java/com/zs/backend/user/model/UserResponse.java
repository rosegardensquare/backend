package com.zs.backend.user.model;

import com.zs.backend.user.entity.User;
import lombok.Data;

@Data
public class UserResponse extends User {

    private String birthdayStr;

}
