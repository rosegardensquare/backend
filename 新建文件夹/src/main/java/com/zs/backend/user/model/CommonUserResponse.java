package com.zs.backend.user.model;

import com.zs.backend.user.entity.CommonUser;
import com.zs.backend.utils.DateUtil;
import lombok.Data;


@Data
public class CommonUserResponse extends CommonUser {

    private String birthdayStr;

    private String createTimeStr;

    private String updateTimeStr;

    public String getBirthdayStr(){
        return DateUtil.dateToString(this.getBirthday(), DateUtil.YMD_FORMAT);
    }

    public String getCreateTimeStr(){
        return DateUtil.dateToString(this.getCreateTime(), DateUtil.DEFAULT_FORMAT);
    }

    public String getUpdateTimeStr(){
        return DateUtil.dateToString(this.getUpdateTime(), DateUtil.DEFAULT_FORMAT);
    }
}
