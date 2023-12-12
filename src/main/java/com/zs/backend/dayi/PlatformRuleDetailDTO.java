package com.zs.backend.dayi;

import java.io.Serializable;
import lombok.Data;

/**
 *平台规则明细
 *@author shy
 */
@Data
public abstract class PlatformRuleDetailDTO implements Serializable {

    /**
     * 触发操作 0 无操作 ，1 人脸识别 2-禁止操作
     */
    protected Integer fireOperation;
}
