package com.zs.backend.menu.entity;

import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author MybatisGenerator
 * @since 2020-12-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_menu")
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    /**
     * 菜单名称
     */
    @TableField("menuName")
    private String menuName;

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

    // transient 声明非数据库字段
    private transient  List<Menu> children = new ArrayList<>();

    public static final String ID = "id";
    public static final String DEL = "del";
    public static final String SORT = "sort";
    public static final String CREATE_TIME = "create_time";



}
