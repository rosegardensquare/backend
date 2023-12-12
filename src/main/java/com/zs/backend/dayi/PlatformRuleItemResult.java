package com.zs.backend.dayi;

import java.io.Serializable;
import lombok.Data;


@Data
public class PlatformRuleItemResult implements Serializable {

    /**
     * 触发操作
     * 0.无需操作
     * 1.人脸识别
     */
    protected Integer fireOperationCode;
}
