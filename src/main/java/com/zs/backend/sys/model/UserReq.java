package com.zs.backend.sys.model;

import com.zs.backend.sys.entity.User;
import lombok.Data;


@Data
public class UserReq extends User {

    private String queryName;

    /**
     * 角色id
     */
    private String roleId;

    /**
     * 是否是更新操作
     */
    private boolean update = false;

}
