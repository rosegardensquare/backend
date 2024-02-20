package com.zs.backend.model.dto.user;

import com.aliyun.oss.common.utils.DateUtil;
import com.zs.backend.model.entity.user.CommonUser;
import lombok.Data;


@Data
public class CommonUserResponse extends CommonUser {

    private String birthdayStr;

    private String createTimeStr;

    private String updateTimeStr;
//
//    public String getBirthdayStr(){
//        return DateUtil.dateToString(this.getBirthday(), DateUtil.YMD_FORMAT);
//    }
//
//    public String getCreateTimeStr(){
//        return DateUtil.dateToString(this.getCreateTime(), DateUtil.DEFAULT_FORMAT);
//    }
//
//    public String getUpdateTimeStr(){
//        return DateUtil.dateToString(this.getUpdateTime(), DateUtil.DEFAULT_FORMAT);
//    }
}
