package com.zs.backend.dayi;

import java.util.List;
import lombok.Data;

/**
 *资金安全规则明细
 *@author shy
 */
@Data
public class TariffRuleDetailDTO extends PlatformRuleDetailDTO {

    private List<TariffRuleDetail> ruleDetail;

}
