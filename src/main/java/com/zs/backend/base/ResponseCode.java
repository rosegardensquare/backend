package com.zs.backend.base;

import java.util.HashMap;
import java.util.Map;

public enum ResponseCode {
    OK(200, "OK"),
    REDIRECT(301, "redirect"),
    BAD_REQUEST(400, "Bad Request"),
    FORBIDDEN(403, "FORBIDDEN"),
    INTERNAL_SERVER_ERROR(500, "common.error");

    public final int code;
    public final String name;
    private static final Map<Integer, ResponseCode> VALUE_MAP = new HashMap();

    private ResponseCode(int code, String name) {
        this.code = code;
        this.name = name;
    }

    static {
        ResponseCode[] var0 = values();
        int var1 = var0.length;

        for(int var2 = 0; var2 < var1; ++var2) {
            ResponseCode err = var0[var2];
            if (VALUE_MAP.put(err.code, err) != null) {
                throw new BaseException("ERROR! ResponseCode 重复定义的值, code=" + err.code);
            }
        }

    }
}
