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
@TableName("sys_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String userName;

    private String passWord;

    private String description;

    private Long state;

    private Long del;

    public static final String ID = "user_id";
    public static final String USER_NAME = "user_name";
    public static final String PASS_WORD = "pass_word";


}
