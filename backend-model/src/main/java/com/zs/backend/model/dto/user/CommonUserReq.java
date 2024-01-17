package com.zs.backend.model.dto.user;

import com.zs.backend.model.entity.user.CommonUser;
import lombok.Data;


@Data
public class CommonUserReq extends CommonUser {

    private String birthdayStr;

    private String queryName;


}
