package com.zs.backend.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author MybatisGenerator
 * @since 2021-01-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_permission")
public class Permis implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    /**
     * 菜单名称
     */
    @TableField("permission_name")
    private String permissionName;

    /**
     * 图标代码
     */
    private String icon;

    /**
     * 路径
     */
    private String path;

    /**
     * 父id
     */
    @TableField("parentId")
    private String parentId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 是否删除
     */
    private Boolean del;

    /**
     * 是否删除
     */
    private String sort;

    @TableField(exist = false)
    private transient List<Permis> children = new ArrayList<>();

    public static final String ID = "id";
    public static final String DEL = "del";
    public static final String SORT = "sort";
    public static final String PERMISSION_NAME = "permission_name";
    public static final String PARENT_ID = "parentId";



}
