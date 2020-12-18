package com.zs.backend.sys.model;

import com.zs.backend.sys.entity.User;
import lombok.Data;


@Data
public class UserReq extends User {

    private String birthdayStr;
    // 根据
    private String queryName;


}
