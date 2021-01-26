package com.zs.backend.sys.model;

import lombok.Data;

import java.util.List;

@Data
public class RoleRes {
    private String id;

    private String roleName;

    private String roleCode;

    private String parentId;

    private List<String> permisIds;


}
