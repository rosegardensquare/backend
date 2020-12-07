package com.zs.backend.test.model;

import com.baomidou.mybatisplus.annotation.*;
import com.zs.backend.test.JSONArrayWrapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author mybatis-plus-generator
 * @since 2020-11-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("logi_order")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 运单编号
     */
    @TableField("order_no")
    private String orderNo;

    /**
     * 计划id
     */
    @TableField("plan_id")
    private Long planId;

    /**
     * 计划编号
     */
    @TableField("plan_no")
    private String planNo;

    /**
     * 调车任务号
     */
    @TableField("shunt_no")
    private String shuntNo;

    /**
     * 合同id
     */
    @TableField("contract_id")
    private Long contractId;

    /**
     * 合同名称
     */
    @TableField("contract_name")
    private String contractName;

    /**
     * 服务税率
     */
    @TableField("service_rate")
    private BigDecimal serviceRate;

    /**
     * 服务费计算方式
     */
    @TableField("service_algo")
    private Integer serviceAlgo;

    /**
     * 油费是否降税点
     */
    @TableField("oil_down_tax")
    private Boolean oilDownTax;

    /**
     * 开票设置0开票后付款，1付款（运费+服务费）后开票，2先支付服务费后开票
     */
    @TableField("check_pay")
    private Integer checkPay;

    /**
     * 是否自动申请付款
     */
    @TableField("auto_apply")
    private Boolean autoApply;

    /**
     * 是否购买保险
     */
    @TableField("buy_ins")
    private Boolean buyIns;

    /**
     * 投保单价
     */
    @TableField("ins_price")
    private BigDecimal insPrice;

    /**
     * 保险税率
     */
    @TableField("ins_rate")
    private BigDecimal insRate;

    /**
     * 线路名称
     */
    @TableField("route_name")
    private String routeName;

    /**
     * 货主公司id
     */
    @TableField("shipper_cid")
    private Long shipperCid;

    /**
     * 货主公司名称
     */
    @TableField("shipper_cname")
    private String shipperCname;

    /**
     * 货主公司联系电话
     */
    @TableField("shipper_tel")
    private String shipperTel;

    /**
     * 车主id
     */
    @TableField("broker_id")
    private Long brokerId;

    /**
     * 车主名称
     */
    @TableField("broker_name")
    private String brokerName;

    /**
     * 车主手机号
     */
    @TableField("broker_tel")
    private String brokerTel;

    /**
     * 承运人id
     */
    @TableField("driver_id")
    private Long driverId;

    /**
     * 承运人名称
     */
    @TableField("driver_name")
    private String driverName;

    /**
     * 承运人手机号
     */
    @TableField("driver_tel")
    private String driverTel;

    /**
     * 承运工具id
     */
    @TableField("vehicle_id")
    private Long vehicleId;

    /**
     * 承运工具牌照号
     */
    @TableField("vehicle_no")
    private String vehicleNo;

    /**
     * 发货人id
     */
    @TableField("consignor_uid")
    private Long consignorUid;

    /**
     * 发货人名称
     */
    @TableField("consignor_uname")
    private String consignorUname;

    /**
     * 发货人电话
     */
    @TableField("consignor_tel")
    private String consignorTel;

    /**
     * 运单来源#ydlydm（1-货主、2-车主）
     */
    @TableField("origin")
    private Integer origin;

    /**
     * 货物名称
     */
    @TableField("goods_name")
    private String goodsName;

    /**
     * 货物重量
     */
    @TableField("goods_weight")
    private BigDecimal goodsWeight;

    /**
     * 货物重量单位#hwzldwdm
     */
    @TableField("goods_weight_unit")
    private String goodsWeightUnit;

    /**
     * 装货地省#xzqhdm
     */
    @TableField("load_province")
    private String loadProvince;

    /**
     * 装货地市#xzqhdm
     */
    @TableField("load_city")
    private String loadCity;

    /**
     * 装货地县#xzqhdm
     */
    @TableField("load_county")
    private String loadCounty;

    /**
     * 装货地详细地址
     */
    @TableField("load_detail")
    private String loadDetail;

    /**
     * 装货地地址
     */
    @TableField("load_addr")
    private String loadAddr;

    /**
     * 装货地经度
     */
    @TableField("load_lon")
    private BigDecimal loadLon;

    /**
     * 装货地纬度
     */
    @TableField("load_lat")
    private BigDecimal loadLat;

    /**
     * 装货地联系人
     */
    @TableField("load_contacts")
    private String loadContacts;

    /**
     * 装货地联系人电话
     */
    @TableField("load_contacts_tel")
    private String loadContactsTel;

    /**
     * 装货地别名
     */
    @TableField("load_addr_alias")
    private String loadAddrAlias;

    /**
     * 卸货地省#xzqhdm
     */
    @TableField("unload_province")
    private String unloadProvince;

    /**
     * 卸货地市#xzqhdm
     */
    @TableField("unload_city")
    private String unloadCity;

    /**
     * 卸货地县#xzqhdm
     */
    @TableField("unload_county")
    private String unloadCounty;

    /**
     * 卸货地详细地址
     */
    @TableField("unload_detail")
    private String unloadDetail;

    /**
     * 卸货地地址
     */
    @TableField("unload_addr")
    private String unloadAddr;

    /**
     * 卸货地经度
     */
    @TableField("unload_lon")
    private BigDecimal unloadLon;

    /**
     * 卸货地纬度
     */
    @TableField("unload_lat")
    private BigDecimal unloadLat;

    /**
     * 卸货地联系人
     */
    @TableField("unload_contacts")
    private String unloadContacts;

    /**
     * 卸货地联系人电话
     */
    @TableField("unload_contacts_tel")
    private String unloadContactsTel;

    /**
     * 卸货地别名
     */
    @TableField("unload_addr_alias")
    private String unloadAddrAlias;

    /**
     * 签收人员,存json数组,包含ID,名称,电话
     */
    @TableField("signer")
    private JSONArrayWrapper signer;

    /**
     * 预估里程
     */
    @TableField("mileage")
    private BigDecimal mileage;

    /**
     * 是否地址保护
     */
    @TableField("addr_hide")
    private Boolean addrHide;

    /**
     * 是否调价
     */
    @TableField("adjust")
    private Boolean adjust;

    /**
     * 总金额,包含运费和油费
     */
    @TableField("total_amount")
    private BigDecimal totalAmount;

    /**
     * 货主调度总运费
     */
    @TableField("shunt_total_amount")
    private BigDecimal shuntTotalAmount;

    /**
     * 可申请支付金额
     */
    @TableField("allow_amount")
    private BigDecimal allowAmount;

    /**
     * 已付金额，包含运费,油费
     */
    @TableField("finish_amount")
    private BigDecimal finishAmount;

    /**
     * 开票金额
     */
    @TableField("invoice_amount")
    private BigDecimal invoiceAmount;

    /**
     * 折扣金额(含税)
     */
    @TableField("invoice_discount_amount")
    private BigDecimal invoiceDiscountAmount;

    /**
     * 货主运费结清时间
     */
    @TableField("shipper_freight_pay_time")
    private Date shipperFreightPayTime;

    /**
     * 服务费结清时间
     */
    @TableField("service_pay_time")
    private Date servicePayTime;

    /**
     * 平台服务费
     */
    @TableField("service_amount")
    private BigDecimal serviceAmount;

    /**
     * 服务费优惠金额
     */
    @TableField("service_discount_amount")
    private BigDecimal serviceDiscountAmount;

    /**
     * 车主运费
     */
    @TableField("broker_amount")
    private BigDecimal brokerAmount;

    /**
     * 车主油费
     */
    @TableField("broker_oil_amount")
    private BigDecimal brokerOilAmount;

    /**
     * 货主运费单价
     */
    @TableField("shipper_price")
    private BigDecimal shipperPrice;

    /**
     * 货主运费含税单价
     */
    @TableField("shipper_price_tax")
    private BigDecimal shipperPriceTax;

    /**
     * 运费单价类型（1-裸车价，2-含税价）
     */
    @TableField("price_type")
    private Integer priceType;

    /**
     * 车主运费单价
     */
    @TableField("broker_price")
    private BigDecimal brokerPrice;

    /**
     * 抹零
     */
    @TableField("change_amount")
    private BigDecimal changeAmount;

    /**
     * 运单扣款
     */
    @TableField("deduction_amount")
    private BigDecimal deductionAmount;

    /**
     * 扣款类型(0-无，1-亏吨扣款)
     */
    @TableField("deduction_type")
    private Integer deductionType;

    /**
     * 签收单价
     */
    @TableField("sign_price")
    private BigDecimal signPrice;

    /**
     * 签收含税单价
     */
    @TableField("sign_price_tax")
    private BigDecimal signPriceTax;

    /**
     * 预付金额
     */
    @TableField("advance_amount")
    private BigDecimal advanceAmount;

    /**
     * 预付比例
     */
    @TableField("advance_ratio")
    private BigDecimal advanceRatio;

    /**
     * 油卡金额
     */
    @TableField("oilcard_amount")
    private BigDecimal oilcardAmount;

    /**
     * 油卡比例
     */
    @TableField("oidcard_ratio")
    private BigDecimal oidcardRatio;

    /**
     * 油费支付方式（1-比例，2-定额）
     */
    @TableField("oilcard_mode")
    private Integer oilcardMode;

    /**
     * 油费支付时机（1-提货付油费，2-签收付油费）
     */
    @TableField("oilcard_opportunity")
    private Integer oilcardOpportunity;

    /**
     * 货主支付油费状态，1：未支付，2：货主已确认,3：成功，4：失败
     */
    @TableField("oil_pay_status")
    private Integer oilPayStatus;

    /**
     * 保险金额
     */
    @TableField("insurance_amount")
    private BigDecimal insuranceAmount;

    /**
     * 投保是否成功
     */
    @TableField("insurance_status")
    private Boolean insuranceStatus;

    /**
     * 结算对象#jsdxdm(1-车主，2-司机)
     */
    @TableField("settle_obj")
    private Integer settleObj;

    /**
     * 接单时间
     */
    @TableField("order_time")
    private Date orderTime;

    /**
     * 提货量
     */
    @TableField("take_capacity")
    private BigDecimal takeCapacity;

    /**
     * 提货单
     */
    @TableField("take_doc")
    private String takeDoc;

    /**
     * 提货时间
     */
    @TableField("take_time")
    private Date takeTime;

    /**
     * 卸货量
     */
    @TableField("unload_capacity")
    private BigDecimal unloadCapacity;

    /**
     * 卸货单
     */
    @TableField("unload_doc")
    private String unloadDoc;

    /**
     * 卸货时间
     */
    @TableField("unload_time")
    private Date unloadTime;

    /**
     * 签收量
     */
    @TableField("sign_capacity")
    private BigDecimal signCapacity;

    /**
     * 签收时间
     */
    @TableField("sign_time")
    private Date signTime;

    /**
     * 签收人id
     */
    @TableField("signer_id")
    private Long signerId;

    /**
     * 签收人名称
     */
    @TableField("signer_name")
    private String signerName;

    /**
     * 运单类型#ydlxdm(1-长期计划，2-指派运力，3-调车计划，4-船运计划)
     */
    @TableField("type")
    private Integer type;

    /**
     * 运单状态#ydztdm(1-待接单，2-待装货，3-运输中，4-待签收，5-已签收，6-已完成，7-已取消)
     */
    @TableField("status")
    private Integer status;

    /**
     * 货主支付状态#hzzfztdm(1-未付款，2-部分付款，3-已结清)
     */
    @TableField("pay_status")
    private Integer payStatus;

    /**
     * 支付完成时间
     */
    @TableField("pay_time")
    private Date payTime;

    /**
     * 平台服务费#ptfwfztdm(1-未付款，2-成功，3-处理中，4-失败)
     */
    @TableField("service_amount_status")
    private Integer serviceAmountStatus;

    /**
     * 货主调车运费状态(1-未付款，2-成功，3-处理中，4-失败)
     */
    @TableField("shunt_amount_status")
    private Integer shuntAmountStatus;

    /**
     * 车主支付状态#czzfztdm(1-未付款，2-成功，3-处理中，4-失败)
     */
    @TableField("broker_pay_status")
    private Integer brokerPayStatus;

    /**
     * 车主油费支付状态(1-未付款，2-成功，3-处理中，4-失败)
     */
    @TableField("broker_oil_pay_status")
    private Integer brokerOilPayStatus;

    /**
     * 车主是否已结清,0:否,1:是
     */
    @TableField("broker_pay_flag")
    private Boolean brokerPayFlag;

    /**
     * 推送时间
     */
    @TableField("push_time")
    private Date pushTime;

    /**
     * 推送状态#zsztdm(0-未推送，1-成功，2-失败)
     */
    @TableField("push_status")
    private Integer pushStatus;

    /**
     * 推送是否异常
     */
    @TableField("push_result")
    private Boolean pushResult;

    /**
     * 推送流水时间
     */
    @TableField("push_money_time")
    private Date pushMoneyTime;

    /**
     * 推送流水状态#zsztdm(0-未推送，1-成功，2-失败)
     */
    @TableField("push_money_status")
    private Integer pushMoneyStatus;

    /**
     * 开票公司id
     */
    @TableField("billing_cid")
    private Long billingCid;

    /**
     * 开票公司名称
     */
    @TableField("billing_cname")
    private String billingCname;

    /**
     * 受票公司id
     */
    @TableField("invoice_cid")
    private Long invoiceCid;

    /**
     * 受票公司名称
     */
    @TableField("invoice_cname")
    private String invoiceCname;

    /**
     * 开票状态#ydkpztdm(1-待开票，2-已开票，3-开票中)
     */
    @TableField("invoice_status")
    private Integer invoiceStatus;

    /**
     * 是否已校验轨迹
     */
    @TableField("check_track")
    private Boolean checkTrack;

    /**
     * 异常标示（第一位表示装货地异常，第二位表示卸货地异常，第三位表示轨迹异常）
     */
    @TableField("unusual_flag")
    private Integer unusualFlag;

    /**
     * 异常证明申请状态 0未申请 1处理中 2 通过 3 驳回
     */
    @TableField("prove_status")
    private Integer proveStatus;

    /**
     * 异常证明审核时间
     */
    @TableField("prove_audit_time")
    private Date proveAuditTime;

    /**
     * 异常证明审核理由
     */
    @TableField("prove_audit_remark")
    private String proveAuditRemark;

    /**
     * 证明上传时间
     */
    @TableField("prove_time")
    private Date proveTime;

    /**
     * 异常证明
     */
    @TableField("prove_doc")
    private String proveDoc;

    /**
     * 收款方id
     */
    @TableField("payee_id")
    private Long payeeId;

    /**
     * 收款方姓名
     */
    @TableField("payee")
    private String payee;

    /**
     * 收款方账号
     */
    @TableField("payee_account")
    private String payeeAccount;

    /**
     * 甲方单号
     */
    @TableField("partya_no")
    private String partyaNo;

    /**
     * 子单号
     */
    @TableField("sub_order_no")
    private String subOrderNo;

    /**
     * 运单来源平台
     */
    @TableField("platform")
    private String platform;

    /**
     * 运单确认，０：未确认，１：已确认
     */
    @TableField("confirm")
    private Boolean confirm;

    /**
     * 历史数据标记
     */
    @TableField("history_flag")
    private Integer historyFlag;

    /**
     * 是否拆分平台服务费
     */
    @TableField("amount_split")
    private Boolean amountSplit;

    /**
     * 采购单号
     */
    @TableField("purchase_no")
    private String purchaseNo;

    /**
     * 三方id
     */
    @TableField("third_id")
    private String thirdId;

    /**
     * 通知单号
     */
    @TableField("notice_no")
    private String noticeNo;

    /**
     * 磅单号
     */
    @TableField("pound_no")
    private String poundNo;

    /**
     * 磅单量
     */
    @TableField("pound_capacity")
    private BigDecimal poundCapacity;

    /**
     * 磅单
     */
    @TableField("pound_doc")
    private String poundDoc;

    /**
     * 磅单时间
     */
    @TableField("pound_time")
    private Date poundTime;

    /**
     * 调车公司
     */
    @TableField("shunt_company")
    private String shuntCompany;

    /**
     * 调车任务价格
     */
    @TableField("shunt_price")
    private BigDecimal shuntPrice;

    /**
     * 收款状态#dyskztdm（1-未收款，2-部分收款，3-已结清）
     */
    @TableField("receive_status")
    private Integer receiveStatus;

    /**
     * 调度人id
     */
    @TableField("dispatch_uid")
    private Long dispatchUid;

    /**
     * 调度人名称
     */
    @TableField("dispatch_uname")
    private String dispatchUname;

    /**
     * 调度人电话
     */
    @TableField("dispatch_tel")
    private String dispatchTel;

    /**
     * 调度人联系人名称
     */
    @TableField("dispatch_contacts_uname")
    private String dispatchContactsUname;

    /**
     * 调度人联系人电话
     */
    @TableField("dispatch_contacts_tel")
    private String dispatchContactsTel;

    /**
     * 装货开始时间
     */
    @TableField("start_load_time")
    private Date startLoadTime;

    /**
     * 装货结束时间
     */
    @TableField("end_load_time")
    private Date endLoadTime;

    /**
     * 是否可用工行融资支付
     */
    @TableField("icbc_credit_usable")
    private Boolean icbcCreditUsable;

    /**
     * 推送工行结果,1: 未推送  2: 已推送 3: 推送已确认 4: 推送已拒绝 5: 取消失败 6:已取消
     */
    @TableField("icbc_push_status")
    private Integer icbcPushStatus;

    /**
     * 创建人id
     */
    @TableField("create_uid")
    private Long createUid;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 更新人id
     */
    @TableField("update_uid")
    private Long updateUid;

    /**
     * 更新时间
     */
    @TableField("update_time")
    private Date updateTime;

    /**
     * 是否删除
     */
    @TableField("del")
    @TableLogic
    private Boolean del;


    public static final String ID = "id";

    public static final String ORDER_NO = "order_no";

    public static final String PLAN_ID = "plan_id";

    public static final String PLAN_NO = "plan_no";

    public static final String SHUNT_NO = "shunt_no";

    public static final String CONTRACT_ID = "contract_id";

    public static final String CONTRACT_NAME = "contract_name";

    public static final String SERVICE_RATE = "service_rate";

    public static final String SERVICE_ALGO = "service_algo";

    public static final String OIL_DOWN_TAX = "oil_down_tax";

    public static final String CHECK_PAY = "check_pay";

    public static final String AUTO_APPLY = "auto_apply";

    public static final String BUY_INS = "buy_ins";

    public static final String INS_PRICE = "ins_price";

    public static final String INS_RATE = "ins_rate";

    public static final String ROUTE_NAME = "route_name";

    public static final String SHIPPER_CID = "shipper_cid";

    public static final String SHIPPER_CNAME = "shipper_cname";

    public static final String SHIPPER_TEL = "shipper_tel";

    public static final String BROKER_ID = "broker_id";

    public static final String BROKER_NAME = "broker_name";

    public static final String BROKER_TEL = "broker_tel";

    public static final String DRIVER_ID = "driver_id";

    public static final String DRIVER_NAME = "driver_name";

    public static final String DRIVER_TEL = "driver_tel";

    public static final String VEHICLE_ID = "vehicle_id";

    public static final String VEHICLE_NO = "vehicle_no";

    public static final String CONSIGNOR_UID = "consignor_uid";

    public static final String CONSIGNOR_UNAME = "consignor_uname";

    public static final String CONSIGNOR_TEL = "consignor_tel";

    public static final String ORIGIN = "origin";

    public static final String GOODS_NAME = "goods_name";

    public static final String GOODS_WEIGHT = "goods_weight";

    public static final String GOODS_WEIGHT_UNIT = "goods_weight_unit";

    public static final String LOAD_PROVINCE = "load_province";

    public static final String LOAD_CITY = "load_city";

    public static final String LOAD_COUNTY = "load_county";

    public static final String LOAD_DETAIL = "load_detail";

    public static final String LOAD_ADDR = "load_addr";

    public static final String LOAD_LON = "load_lon";

    public static final String LOAD_LAT = "load_lat";

    public static final String LOAD_CONTACTS = "load_contacts";

    public static final String LOAD_CONTACTS_TEL = "load_contacts_tel";

    public static final String LOAD_ADDR_ALIAS = "load_addr_alias";

    public static final String UNLOAD_PROVINCE = "unload_province";

    public static final String UNLOAD_CITY = "unload_city";

    public static final String UNLOAD_COUNTY = "unload_county";

    public static final String UNLOAD_DETAIL = "unload_detail";

    public static final String UNLOAD_ADDR = "unload_addr";

    public static final String UNLOAD_LON = "unload_lon";

    public static final String UNLOAD_LAT = "unload_lat";

    public static final String UNLOAD_CONTACTS = "unload_contacts";

    public static final String UNLOAD_CONTACTS_TEL = "unload_contacts_tel";

    public static final String UNLOAD_ADDR_ALIAS = "unload_addr_alias";

    public static final String SIGNER = "signer";

    public static final String MILEAGE = "mileage";

    public static final String ADDR_HIDE = "addr_hide";

    public static final String ADJUST = "adjust";

    public static final String TOTAL_AMOUNT = "total_amount";

    public static final String SHUNT_TOTAL_AMOUNT = "shunt_total_amount";

    public static final String ALLOW_AMOUNT = "allow_amount";

    public static final String FINISH_AMOUNT = "finish_amount";

    public static final String INVOICE_AMOUNT = "invoice_amount";

    public static final String INVOICE_DISCOUNT_AMOUNT = "invoice_discount_amount";

    public static final String SHIPPER_FREIGHT_PAY_TIME = "shipper_freight_pay_time";

    public static final String SERVICE_PAY_TIME = "service_pay_time";

    public static final String SERVICE_AMOUNT = "service_amount";

    public static final String SERVICE_DISCOUNT_AMOUNT = "service_discount_amount";

    public static final String BROKER_AMOUNT = "broker_amount";

    public static final String BROKER_OIL_AMOUNT = "broker_oil_amount";

    public static final String SHIPPER_PRICE = "shipper_price";

    public static final String SHIPPER_PRICE_TAX = "shipper_price_tax";

    public static final String PRICE_TYPE = "price_type";

    public static final String BROKER_PRICE = "broker_price";

    public static final String CHANGE_AMOUNT = "change_amount";

    public static final String DEDUCTION_AMOUNT = "deduction_amount";

    public static final String DEDUCTION_TYPE = "deduction_type";

    public static final String SIGN_PRICE = "sign_price";

    public static final String SIGN_PRICE_TAX = "sign_price_tax";

    public static final String ADVANCE_AMOUNT = "advance_amount";

    public static final String ADVANCE_RATIO = "advance_ratio";

    public static final String OILCARD_AMOUNT = "oilcard_amount";

    public static final String OIDCARD_RATIO = "oidcard_ratio";

    public static final String OILCARD_MODE = "oilcard_mode";

    public static final String OILCARD_OPPORTUNITY = "oilcard_opportunity";

    public static final String OIL_PAY_STATUS = "oil_pay_status";

    public static final String INSURANCE_AMOUNT = "insurance_amount";

    public static final String INSURANCE_STATUS = "insurance_status";

    public static final String SETTLE_OBJ = "settle_obj";

    public static final String ORDER_TIME = "order_time";

    public static final String TAKE_CAPACITY = "take_capacity";

    public static final String TAKE_DOC = "take_doc";

    public static final String TAKE_TIME = "take_time";

    public static final String UNLOAD_CAPACITY = "unload_capacity";

    public static final String UNLOAD_DOC = "unload_doc";

    public static final String UNLOAD_TIME = "unload_time";

    public static final String SIGN_CAPACITY = "sign_capacity";

    public static final String SIGN_TIME = "sign_time";

    public static final String SIGNER_ID = "signer_id";

    public static final String SIGNER_NAME = "signer_name";

    public static final String TYPE = "type";

    public static final String STATUS = "status";

    public static final String PAY_STATUS = "pay_status";

    public static final String PAY_TIME = "pay_time";

    public static final String SERVICE_AMOUNT_STATUS = "service_amount_status";

    public static final String SHUNT_AMOUNT_STATUS = "shunt_amount_status";

    public static final String BROKER_PAY_STATUS = "broker_pay_status";

    public static final String BROKER_OIL_PAY_STATUS = "broker_oil_pay_status";

    public static final String BROKER_PAY_FLAG = "broker_pay_flag";

    public static final String PUSH_TIME = "push_time";

    public static final String PUSH_STATUS = "push_status";

    public static final String PUSH_RESULT = "push_result";

    public static final String PUSH_MONEY_TIME = "push_money_time";

    public static final String PUSH_MONEY_STATUS = "push_money_status";

    public static final String BILLING_CID = "billing_cid";

    public static final String BILLING_CNAME = "billing_cname";

    public static final String INVOICE_CID = "invoice_cid";

    public static final String INVOICE_CNAME = "invoice_cname";

    public static final String INVOICE_STATUS = "invoice_status";

    public static final String CHECK_TRACK = "check_track";

    public static final String UNUSUAL_FLAG = "unusual_flag";

    public static final String PROVE_STATUS = "prove_status";

    public static final String PROVE_AUDIT_TIME = "prove_audit_time";

    public static final String PROVE_AUDIT_REMARK = "prove_audit_remark";

    public static final String PROVE_TIME = "prove_time";

    public static final String PROVE_DOC = "prove_doc";

    public static final String PAYEE_ID = "payee_id";

    public static final String PAYEE = "payee";

    public static final String PAYEE_ACCOUNT = "payee_account";

    public static final String PARTYA_NO = "partya_no";

    public static final String SUB_ORDER_NO = "sub_order_no";

    public static final String PLATFORM = "platform";

    public static final String CONFIRM = "confirm";

    public static final String HISTORY_FLAG = "history_flag";

    public static final String AMOUNT_SPLIT = "amount_split";

    public static final String PURCHASE_NO = "purchase_no";

    public static final String THIRD_ID = "third_id";

    public static final String NOTICE_NO = "notice_no";

    public static final String POUND_NO = "pound_no";

    public static final String POUND_CAPACITY = "pound_capacity";

    public static final String POUND_DOC = "pound_doc";

    public static final String POUND_TIME = "pound_time";

    public static final String SHUNT_COMPANY = "shunt_company";

    public static final String SHUNT_PRICE = "shunt_price";

    public static final String RECEIVE_STATUS = "receive_status";

    public static final String DISPATCH_UID = "dispatch_uid";

    public static final String DISPATCH_UNAME = "dispatch_uname";

    public static final String DISPATCH_TEL = "dispatch_tel";

    public static final String DISPATCH_CONTACTS_UNAME = "dispatch_contacts_uname";

    public static final String DISPATCH_CONTACTS_TEL = "dispatch_contacts_tel";

    public static final String START_LOAD_TIME = "start_load_time";

    public static final String END_LOAD_TIME = "end_load_time";

    public static final String ICBC_CREDIT_USABLE = "icbc_credit_usable";

    public static final String ICBC_PUSH_STATUS = "icbc_push_status";

    public static final String CREATE_UID = "create_uid";

    public static final String CREATE_TIME = "create_time";

    public static final String UPDATE_UID = "update_uid";

    public static final String UPDATE_TIME = "update_time";

    public static final String DEL = "del";

}
