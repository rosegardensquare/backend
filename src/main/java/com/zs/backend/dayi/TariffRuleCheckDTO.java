package com.zs.backend.dayi;

import java.math.BigDecimal;
import lombok.Data;

/**
 *运价规则检查所需参数<br>
 * 配合 BasePlatformCheckCmd使用
 *@author shy
 */
@Data
public class TariffRuleCheckDTO implements PlatformRuleCheckDTO {

    /**
     * 货物单位
     */
    private String goodsWeightUnit;

    /**
     * 运输里程
     */
    private BigDecimal mileage;

    /**
     * 公里单价
     * 计算方式(保留三位小数)：
     *        1.指派运力或补单计算方式：总运费/货物总量/运输里程；
     *        2.其余方式：货物单价/运输里程；
     *        3.签收时公里单价=结算裸车（含税）价/运输里程；
     */
    private BigDecimal mileagePrice;

    /**
     * 货物单位编码(不需要传)
     */
    private Integer goodsWeightUnitCode;

    /**
     * 裸车价
     */
    private BigDecimal shipperPrice;

    /**
     * 运单总价
     */
    private BigDecimal totalAmount;

    /**
     * 货主签收量
     */
    private BigDecimal signCapacity;

    /**
     * 货主卸货量
     */
    private BigDecimal shipperUnloadCapacity;

    /**
     * 货主提货量
     */
    private BigDecimal shipperTakeCapacity;

    /**
     * 司机卸货量
     */
    private BigDecimal driverUnloadCapacity;

    /**
     * 司机提货量
     */
    private BigDecimal driverTakeCapacity;

    /**
     * （货主卸货量-货主提货量）绝对值
     */
    private BigDecimal signCapacityAbs_1;

    /**
     * （货主卸货量-货主签收量）绝对值
     */
    private BigDecimal signCapacityAbs_2;

    /**
     * （货主提货量-司机提货量）绝对值
     */
    private BigDecimal signCapacityAbs_3;


    /**
     * （货主卸货量-司机卸货量）绝对值
     */
    private BigDecimal signCapacityAbs_4;


}
