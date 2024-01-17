package com.zs.backend.security.handler;


/**
 * Created by pengq on 2019/9/7 12:29.
 */
public class SuccessResponse extends GenericResponse {
    private static final GlobalResponseCode success = GlobalResponseCode.SUCCESS;

    public SuccessResponse() {
        super(Integer.parseInt(success.getCode() + ""), success.getMsg());
    }

    public SuccessResponse(int code, String message) {
        super(code, message);
    }

    @Override
    public String getMsg() {
        return null;
    }
}
