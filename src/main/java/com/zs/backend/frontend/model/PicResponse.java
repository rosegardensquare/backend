package com.zs.backend.frontend.model;

import com.zs.backend.mata.entity.FrontMetadata;
import com.zs.backend.user.entity.CommonUser;
import com.zs.backend.utils.DateUtil;
import lombok.Data;


@Data
public class PicResponse extends FrontMetadata {

    private String createTimeStr;

    private String updateTimeStr;

    public String getCreateTimeStr(){
        return DateUtil.dateToString(this.getCreateTime(), DateUtil.DEFAULT_FORMAT);
    }

    public String getUpdateTimeStr(){
        return DateUtil.dateToString(this.getUpdateTime(), DateUtil.DEFAULT_FORMAT);
    }
}
