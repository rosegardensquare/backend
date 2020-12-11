package com.zs.backend.user.model;

import com.zs.backend.user.entity.User;
import lombok.Data;

@Data
public class UserReq extends User {

    private String birthdayStr;
    // 根据
    private String queryName;


}
