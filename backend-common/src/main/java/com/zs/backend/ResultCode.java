package com.zs.backend;

public enum ResultCode {
    /**
     * 20000:"成功"
     */
    SUCCESS(20000, "成功"),
    /**
     * 20001:"失败"
     */
    ERROR(20001, "失败"),
    /**
     * 3005:"密码不正确!"
     */
    PASS_NOT_CORRECT(3005, "密码不正确!请重新尝试!"),

    /**
     * 3006:"算数异常"
     */
    ARITHMETIC_EXCEPTION(3006, "算数异常"),

    /**
     * 3007:"用户不存在"
     */
    USER_NOT_FOUND_EXCEPTION(3007, "用户不存在"),
    /**
     * 3006:"尚未登录!"
     */
    NOT_LOGIN(3006, "尚未登录!"),
    /**
     * 2005:"没有找到这一条历史信息!有人侵入数据库强制删除了!"
     */
    INTRODUCTION_NOT_FOUND(2005, "没有找到这一条历史信息!有人侵入数据库强制删除了!"),
    /**
     * 404:没有找到对应的请求路径
     */
    PAGE_NOT_FOUND(404, "你要请求的页面好像暂时飘走了...要不试试请求其它页面?"),
    /**
     * 500:服务端异常
     */
    INTERNAL_SERVER_ERROR(500, "服务器冒烟了...要不等它降降温后再来访问?"),
    /**
     * 2001:未知异常
     */
    UNKNOW_SERVER_ERROR(2001, "未知异常,请联系管理员!");

    private Integer code;

    private String message;

    ResultCode(Integer code,String message){
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    interface CustomizeResultCode {

        /**
         * 获取错误状态码
         * @return 错误状态码
         */
        Integer getCode();

        /**
         * 获取错误信息
         * @return 错误信息
         */
        String getMessage();
    }


}
