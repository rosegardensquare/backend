package com.zs.backend.dayi;


import java.util.Date;
import java.util.Map;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 *
 *@author shy
 */
@Data
@Slf4j
public class PlatformRuleEntity  {

    /**
     * 风控规则id
     */
    private Long id;
    /**
     * 风控规则类型
     */
    private Integer ruleType;

    /**
     * 用户端 2 联盟 ，3 司机
     */
    private Integer userType;

    /**
     * 风控适用类型fksylxdm 1 提现
     */
    private Integer ruleScenario;

    /**
     * 风控细则
     */
    private String ruleDetail;

    /**
     * 是否启用 true 启用， false 禁用
     */
    private Boolean enabled;

    /**
     * 规则编码
     */
    private String ruleCode;

    /**
     * 运价规则名称
     */
    private String tariffRuleName;

    /**
     * 适用运单类型(1 长期计划、2 指派运力、3 短途多趟、4 车货匹配）
     */
    private Integer ruleOrderType;


    /**
     * 适用运单类型(1 长期计划、2 指派运力、3 短途多趟、4 车货匹配）
     */
    private String ruleOrderTypes;

    /**
     * 运价规则适用类型（适用节点，多个以逗号分割）
     */
    private String ruleScenarios;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 更新人id
     */
    private Long updateUid;

    /**
     * 更新人
     */
    private String updateUname;

    /**
     * 风控细则 map 用于唯一校验
     */
    private Map<String, Object> ruleDetailMap;



    public String key() {
        return String.format("%d.%d.%d", ruleType, userType, ruleScenario);
    }









}
