package com.zs.backend.model.entity.user;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author MybatisGenerator
 * @since 2020-12-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CommonUser implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    /**
     * 用户名
     */
    private String name;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 手机号
     */
    private String tel;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 密码
     */
    private String password;

    /**
     * 性别（ 1：男；2：女）
     */
    private Integer sex;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 是否删除
     */
    private Boolean del;

    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String NICKNAME = "nickname";
    public static final String TEL = "tel";
    public static final String BIRTHDAY = "birthday";
    public static final String SEX = "sex";
    public static final String DEL = "del";
    public static final String CREATE_TIME = "create_time";
    public static final String UPDATE_TIME = "update_time";



}
