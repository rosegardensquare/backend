package com.zs.backend.sys.model;

import com.zs.backend.sys.entity.User;
import com.zs.backend.user.entity.CommonUser;
import com.zs.backend.utils.DateUtil;
import lombok.Data;


@Data
public class UserResponse extends User {


    private String createTimeStr;

    private String updateTimeStr;

    private String roleId;

    public String getCreateTimeStr(){
        return DateUtil.dateToString(this.getCreateTime(), DateUtil.DEFAULT_FORMAT);
    }

    public String getUpdateTimeStr(){
        return DateUtil.dateToString(this.getUpdateTime(), DateUtil.DEFAULT_FORMAT);
    }
}
