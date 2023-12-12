package com.zs.backend.dayi;

import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 *平台规则触发操作枚举
 *@author shy
 */
@Getter
@AllArgsConstructor
public enum PlatformRuleFireOperationEnum {
    NO_OP(0,"无需操作"),
    FACE_CHECK(1,"人脸识别"),
    FORBIDDEN (2,"禁止操作"),
    SIGN_RISK (3,"触发签收风控"),

    ;
    private Integer code;
    private String desc;

    public static PlatformRuleFireOperationEnum valueOf(Integer code){
        return Arrays.stream(values()).filter(e->e.code.equals(code)).findFirst().orElseThrow(IllegalArgumentException::new);
    }
}
