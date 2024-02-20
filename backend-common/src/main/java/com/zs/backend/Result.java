package com.zs.backend;

import lombok.Data;


@Data
public class Result {

    private Boolean success;

    private Integer code;

    private String message;

    private Object data;

    /**
     * 构造方法私有化,里面的方法都是静态方法
     * 达到保护属性的作用
     */
    private Result(){

    }


    public static Result result(Object value){
        Result result = new Result();
        result.setData(value);
        result.setSuccess(true);
        result.setCode(ResultCode.SUCCESS.getCode());
        result.setMessage(ResultCode.SUCCESS.getMessage());
        return result;
    }


}
