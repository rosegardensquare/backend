package com.zs.backend.test;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 运单扩展信息
 * </p>
 *
 * @author mybatis-plus-generator
 * @since 2019-12-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("logi_order_extend")
public class OrderExtend implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId("id")
    private Long id;

    /**
     * 货主分数
     */
    @TableField("shipper_score")
    private BigDecimal shipperScore;

    /**
     * 司机分数
     */
    @TableField("driver_score")
    private BigDecimal driverScore;

    /**
     * 货主评分信息：保存 json 数组，包含评分项目 ID、分数[{"scoreItemId":"","scoreLevel":1}]
     */
    @TableField("shipper_score_info")
    private JSONArrayWrapper shipperScoreInfo;

    /**
     * 司机评分信息：保存 json 数组，包含评分项目 ID、分数[{"scoreItemId":"","scoreLevel":1}]
     */
    @TableField("driver_score_info")
    private JSONArrayWrapper driverScoreInfo;

    /**
     * 司机id
     */
    @TableField("driver_id")
    private Long driverId;

    /**
     * 货主id
     */
    @TableField("shipper_id")
    private Long shipperId;

    /**
     * 货主评分时间
     */
    @TableField("shipper_score_time")
    private Date shipperScoreTime;

    /**
     * 司机评分时间
     */
    @TableField("driver_score_time")
    private Date driverScoreTime;

    /**
     * 货主是否已评分
     */
    @TableField("is_shipper_score")
    private Integer isShipperScore;

    /**
     * 司机是否已评分
     */
    @TableField("is_driver_score")
    private Integer isDriverScore;

    /**
     * 评分时间
     */
    @TableField("score_time")
    private Date scoreTime;

    /**
     * 是否已评分
     */
    @TableField("is_score")
    private Integer isScore;

    /**
     * 运单是否已传省平台
     */
    @TableField("order_upload")
    private Integer orderUpload;

    /**
     * 资金是否已传省平台
     */
    @TableField("money_upload")
    private Integer moneyUpload;

    /**
     * 运单上传时间
     */
    @TableField("order_upload_time")
    private Date orderUploadTime;

    /**
     * 资金上传时间
     */
    @TableField("money_upload_time")
    private Date moneyUploadTime;

    /**
     * 是否需传省平台
     */
    @TableField("is_upload")
    private Integer isUpload;

    /**
     * 运单状态
     */
    private Integer status;


    public static final String ID = "id";

    public static final String SHIPPER_SCORE = "shipper_score";

    public static final String DRIVER_SCORE = "driver_score";

    public static final String SHIPPER_SCORE_DETAIL = "shipper_score_detail";

    public static final String DRIVER_SCORE_DETAIL = "driver_score_detail";

    public static final String DRIVER_ID = "driver_id";

    public static final String SHIPPER_ID = "shipper_id";

    public static final String SHIPPER_SCORE_TIME = "shipper_score_time";

    public static final String DRIVER_SCORE_TIME = "driver_score_time";

    public static final String IS_SHIPPER_SCORE = "is_shipper_score";

    public static final String IS_DRIVER_SCORE = "is_driver_score";

    public static final String SCORE_TIME = "score_time";

    public static final String IS_SCORE = "is_score";

    public static final String ORDER_UPLOAD = "order_upload";

    public static final String MONEY_UPLOAD = "money_upload";

    public static final String ORDER_UPLOAD_TIME = "order_upload_time";

    public static final String MONEY_UPLOAD_TIME = "money_upload_time";

    public static final String IS_UPLOAD = "is_upload";

}
