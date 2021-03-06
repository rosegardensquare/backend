package com.zs.backend.security.handler;

import com.baomidou.mybatisplus.extension.api.IErrorCode;

public enum GlobalResponseCode implements IErrorCode {
    SUCCESS(200, "操作成功！"),

    //账户相关
    USERNAME_OR_PASSWORD_ERROR(501, "您输入的用户名或密码不正确！"),
    ACCOUNT_LOCKED_ERROR(502, "账户被锁定！"),
    CREDENTIALS_EXPIRED_ERROR(503, "密码过期！"),
    ACCOUNT_EXPIRED_ERROR(504, "账户过期！"),
    ACCOUNT_DISABLED_ERROR(505, "账户被禁用！"),
    VALIDATE_CODE_NOT_MATCHED_ERROR(506, "验证码不匹配！"),
    LOGIN_FAILED_ERROR(507, "登录失败！"),
    USERNAME_NOT_FOUND_ERROR(508, "用户名不存在！"),
    //权限
    ACCESS_FORBIDDEN_ERROR(403, "无访问权限");


    private int code;
    private String msg;

    GlobalResponseCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public long getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }

}
