package com.zs.backend.user.model;

import com.zs.backend.user.entity.CommonUser;
import lombok.Data;


@Data
public class CommonUserReq extends CommonUser {

    private String birthdayStr;

    private String queryName;


}
