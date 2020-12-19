package com.zs.backend.security.handler;


public class ErrorResponse extends GenericResponse {
    public ErrorResponse(GlobalResponseCode globalResponseCode) {
        super(Integer.parseInt(globalResponseCode.getCode() + ""), globalResponseCode.getMsg());
    }


}
