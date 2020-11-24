package com.zs.backend.test;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author <a href="mailto:zhaoxiufei@gmail.com">赵秀非</a>
 * @since 2019-10-15 14:03
 */
@Getter
@AllArgsConstructor
public enum OrderStatusQueryEnum {
    ALL(1, "全部"),
    WAITING_TAKE(2, "待接单"),
    WAITING_LOAD(3, "待提货"),
    /**
     * 货主运输中：该货主发布的，运单状态为【待提货、待卸货】的运单
     */
    SHIPPER_IN_TRANSIT(4, "运输中"),
    /**
     * 待签收：该货主发布的，运单已卸货，但货主未进行签收动作的运单
     */
    WAITING_RECEIVE(5, "待签收"),
    /**
     * 该车主承运的，运单状态为【已签收】未付款
     */
    BROKER_WAITING_PAYMENT(6, "车主待付款"),
    /**
     * 该货主发布的，运单状态为【已签收】未结清.tip:货主可以多次支付车主
     */
    SHIPPER_WAITING_PAYMENT(7, "货主待付款"),
    /**
     * 该车主承运的，运单状态为【已签收】,但货主未结清
     */
    BROKER_WAITING_RECEIVABLE(8, "车主待收款"),
    BROKER_COMPLETED(9, "车主已完成"),

    /**
     * 车主运输中：运单状态为【待提货、待卸货、待签收】的运单
     */
    BROKER_IN_TRANSIT(10, "运输中"),
    SHIPPER_COMPLETED(11, "货主已完成"),

//-----------------------------车主开始-------------------------

    /**
     * 全部：该车主承运的，全部运单状态的运单
     */
    BROKER_ALL(200, "全部"),
    /**
     * 待接单：该车主承运的，运单状态为【待接单】的运单
     */
    BROKER_WAITING_TAKE(201, "待接单"),
    /**
     * 待提货：该车主承运的，运单状态为【待提货】的运单
     */
    BROKER_WAITING_LOAD(202, "待提货"),
    /**
     * 待卸货：该车主承运的，运单状态为【待卸货】的运单
     */
    BROKER_WAITING_UNLOAD(203, "待卸货"),
    /**
     * 待签收：该车主承运的，运单状态为【待签收】的运单
     */
    BROKER_WAITING_RECEIVE(204, "待签收"),
    /**
     * 已签收：该车主承运的，运单状态为【已签收】的运单
     */
    BROKER_ALREADY_RECEIVE(205, "已签收"),
    /**
     * 待付款：该车主承运的且结算对象为车主的，运单状态为【已签收】【已完成】但车主未进行（成功的）线上支付的运单
     */
    BROKER_WAITING_PAY(206, "待付款"),
    /**
     * 待收款：该车主承运的且结算对象为车主的,[联盟未标记已结清]，运单状态为【已签收】（待付运费不等于0的运单（待付运费 = 签收总运费 - 货主已支付运费）
     */
    BROKER_WAITING_PENDING_PAYMENT(207, "待收款"),
    /**
     * 已收款：该车主承运的且结算对象为车主的，运单状态为【已完成】的运单
     */
    BROKER_ALREADY_RECEIVED_MONEY(208, "已收款"),
    /**
     * 已取消：该车主承运的，运单状态为【已取消】的运单
     */
    BROKER_CANCELLED(209, "已取消"),
    /**
     * 全部：该车主承运的，全部运单状态的运单
     */
    BROKER_NOT_CANCELED(210, "全部包含取消的运单"),
    /**
     * "待扣保险的运单
     */
    BROKER_PENDING_INSURANCE(211, "待扣保险的运单"),
    /**
     * 带扣税金的运单
     */
    BROKER_PENDING_TAXES(212, "待扣税金的运单"),
//-----------------------------司机开始-------------------------
    /**
     * 全部：该司机承运的，全部运单状态的运单
     */
    DRIVER_ALL(300, "全部"),
    /**
     * 待接单：该司机承运的，运单状态为【待接单】的运单
     */
    DRIVER_WAITING_TAKE(301, "待接单"),
    /**
     * 待提货：该司机承运的，运单状态为【待提货】的运单
     */
    DRIVER_WAITING_LOAD(302, "待提货"),
    /**
     * 待卸货：该司机承运的，运单状态为【待卸货】的运单
     */
    DRIVER_WAITING_UNLOAD(303, "待卸货"),
    /**
     * 待签收：该司机承运的，运单状态为【待签收】的运单
     */
    DRIVER_WAITING_RECEIVE(304, "待签收"),
    /**
     * 已签收：该司机承运的，运单状态为【已签收】的运单
     */
    DRIVER_ALREADY_RECEIVE(305, "已签收"),
    /**
     * 已完成：该司机承运的，运单状态为【已完成】的运单
     */
    DRIVER_ALREADY_COMPLETED(306, "已完成"),
    /**
     * 已取消：该司机承运的，运单状态为【已取消】的运单
     */
    DRIVER_CANCELLED(307, "已取消"),
    /**
     * 货主结算：该司机承运的，运单状态【已签收、已完成】，且结算对象为司机
     */
    DRIVER_SETTLE_SHIPPER(308, "货主结算"),
    /**
     * 车主结算：该司机承运的，运单状态为【已完成】运单，且结算对象为车主
     */
    DRIVER_SETTLE_BROKER(309, "车主结算"),
    /**
     * 待上传磅单：待卸货，且提货磅单为空 待签收，且提货磅单为空或卸货磅单为空
     */
    DRIVER_NOT_DOC(310, "待上传磅单"),

//-----------------------------司机开始 v1.2-------------------------
    /**
     * 全部：该司机承运的，运单状态为【待接单、待提货、待卸货、待签收、已签收】
     */
    DRIVER_ALL_ALL(400, "全部-全部"),

    /**
     * 进行中：该司机承运的，运单状态为【待接单、待提货、待卸货】
     */
    DRIVER_ON_GOING_ALL(401, "进行中"),

    /**
     * 未结清-全部，运单状态为【未结清-货主（司机）结算、未结清-车主（联盟）结算】
     */
    DRIVER_UNSETTLE_ALL(311, "未结清-全部"),

    /**
     * 未结清-货主结算
     * 1:运单结算对象 =【承运人(司机)】&计划类型=【长期计划、指派运力】，运单状态 in （待卸货、待签收、已签收、已完成）运单支付状态不等于【已结清】
     * 2:运单结算对象 =【承运人】&计划类型= 【大易调车】，运单状态 in （已签收、已完成）& 结算运费 - 已支付运费 - 已支付油费  > 0
     */
    DRIVER_UNSETTLE_SHIPPER(312, "未结清-货主结算"),

    /**
     * 未结清-联盟结算
     * 运单结算对象 =【联盟】，运单状态 in （待卸货、待签收、已签收、已完成）运单下游联盟未标记运单【联盟已结清】的
     */
    DRIVER_UNSETTLE_BROKER(313, "未结清-联盟结算"),

    /**
     * 已结清-全部，运单状态为【已结清-货主结算、已结清-车主结算】
     */
    DRIVER_SETTLED_ALL(314, "已结清-全部"),

    /**
     * 已结清-货主结算
     * 1：运单结算对象 =【承运人】，运单状态 in （已签收、已完成）运单支付状态等于【已结清】
     * 2：运单结算对象 =【承运人】&计划类型= 【大易调车】，运单状态 in （已签收、已完成）& 结算运费 - 已支付运费 - 已支付油费  <= 0
     */
    DRIVER_SETTLED_SHIPPER(315, "已结清-货主结算"),

    /**
     * 已结清-联盟结算
     * 运单结算对象 =【联盟】，运单状态 in （待卸货、待签收、已签收、已完成）运单下游联盟标记运单【联盟已结清】的
     */
    DRIVER_SETTLED_BROKER(316, "已结清-联盟结算"),

    /**
     * 待上传磅单
     */
    DRIVER_WAITING_UPLOAD_POUND(310, "待上传磅单"),
    ;
    private Integer value;
    private String name;

    //dot modify
    public static OrderStatusQueryEnum valueOf(Integer value) {
        if (value == null) {
            return null;
        }
        for (OrderStatusQueryEnum orderStatusEnum : OrderStatusQueryEnum.values()) {
            if (orderStatusEnum.getValue().equals(value)) {
                return orderStatusEnum;
            }
        }
        return null;
    }
}
