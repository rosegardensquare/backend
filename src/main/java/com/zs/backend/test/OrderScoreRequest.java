package com.zs.backend.test;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;


@Data
public class OrderScoreRequest {

    /**
     * 运单ID
     */
    private Long orderId;

    /**
     * 司机ID或者货主ID
     */
    private Long operatorId;


    /**
     * 评分信息
     */
    private List<ScoreDTO> scoreInfo;


    /**
     * 评分信息
     */
    private JSONArrayWrapper scoreInfo_2;


    /**
     * 评分角色
     */
    private Integer userType;

    public JSONArrayWrapper getScoreInfo_2() {
        return new JSONArrayWrapper(this.scoreInfo);
    }




}
