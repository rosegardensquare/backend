package com.zs.backend.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderExtendDTO implements Serializable {

    /**
     * id
     */
    private Long id;

    /**
     * 货主分数
     */
    private BigDecimal shipperScore = BigDecimal.ZERO;

    /**
     * 司机分数
     */
    private BigDecimal driverScore = BigDecimal.ZERO;

    /**
     * 评分时间
     */
    private Date scoreTime;

    /**
     * 是否已评分
     */
    private Integer isScore;

    /**
     * 运单是否已传省平台
     */
    private Integer orderUpload;

    /**
     * 资金是否已传省平台
     */
    private Integer moneyUpload;

    /**
     * 运单上传时间
     */
    private Date orderUploadTime;

    /**
     * 资金上传时间
     */
    private Date moneyUploadTime;

    /**
     * 是否需传省平台
     */
    private Integer isUpload;

    /**
     * 货主评分信息
     */
    private JSONArrayWrapper shipperScoreInfo;

    /**
     * 司机评分信息
     */
    private JSONArrayWrapper driverScoreInfo;

    /**
     * 评分信息
     */
    private JSONArrayWrapper scoreInfo;

    /**
     * 司机id
     */
    private Long driverId;

    /**
     * 货主id
     */
    private Long shipperId;

    /**
     * 货主评分时间
     */
    private Date shipperScoreTime;

    /**
     * 司机评分时间
     */
    private Date driverScoreTime;

    /**
     * 货主是否已评分
     */
    private Integer isShipperScore;

    /**
     * 司机是否已评分
     */
    private Integer isDriverScore;

    /**
     * 评分角色
     */
    private Integer userType;


    /**
     * 司机ID或者货主ID
     */
    private Long operatorId;

}
