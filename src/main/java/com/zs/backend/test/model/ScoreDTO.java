package com.zs.backend.test.model;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 @author 张帅
 @date 2020-11-11
 */
@Data
public class ScoreDTO implements Serializable {
    /**
     * 评分项目 code
     */
    private String scoreItemCode;

    /**
     * 评分等级
     */
    private BigDecimal scoreLevel;

    /**
     * 评分项目名称
     */
    private String scoreName;
}
