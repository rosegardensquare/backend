package com.zs.backend.sys.model;

import com.zs.backend.sys.entity.Role;
import lombok.Data;

import java.util.List;

@Data
public class RoleRequest extends Role {

    private List<String> permisIds;


}
