package com.zs.backend.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author MybatisGenerator
 * @since 2020-12-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_role")
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String roleName;

    private String roleCode;

    private String parentId;


    public static final String PARENT_ID = "parent_id";
    public static final String ROLE_NAME = "role_name";


}
