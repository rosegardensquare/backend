package com.zs.backend.sys.model;

import com.zs.backend.base.CommonPageReq;
import lombok.Data;

import java.util.List;

@Data
public class RoleReq extends CommonPageReq {

    private String roleName;
    private List<String> permisIds;

}
