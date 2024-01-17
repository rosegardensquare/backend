package com.zs.backend.dayi;

import lombok.Data;

@Data
public class TariffRuleDetail extends PlatformRuleDetailDTO {

    /**
     * 前置条件(货物单位表达式)
     */
    private String preRule;

    /**
     * 指标配置 :运输里程 > 10 或 公里单价 > 20
     */
    private String tariffRule;

    /**
     * 执行动作
     */
    private Integer action;

}
