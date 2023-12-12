package com.zs.backend.dayi;

import java.io.Serializable;
import java.util.List;
import lombok.Builder;
import lombok.Data;

/**
 *平台风控检查结果
 *@author shy
 */
@Data
@Builder
public class PlatformRuleResult implements Serializable {

    /**
     * 平台规则id
     */
    protected Long ruleId;
    /**
     * 触发操作
     * 0.无需操作
     * 1.人脸识别
     */
    protected PlatformRuleFireOperationEnum fireOperation;
    /**
     * 备注消息
     */
    protected String msg;

    private List<PlatformRuleItemResult> itemResults;

}
