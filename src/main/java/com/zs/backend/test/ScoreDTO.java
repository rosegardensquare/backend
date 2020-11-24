package com.zs.backend.test;

import lombok.Data;

import java.math.BigDecimal;

/**
 @author 张帅
 @date 2020-11-11
 */
@Data
public class ScoreDTO {
    /**
     * 评分项目Id
     */
    private Long scoreItemId;

    /**
     * 评分等级
     */
    private BigDecimal scoreLevel;

}
