package com.zs.backend.service.strategy;

import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 预警类型枚举
 *
 */
@AllArgsConstructor
@Getter
public enum WarningTypeEnum {

    /**
     * 履约预警 keepAgreement
     */
    KEEP_AGREEMENT_WARNING(1, "keepAgreement", "履约预警"),

    /**
     * 晚点预警
     */
    DELAY_WARNING(2, "delay", "晚点预警"),

    /**
     * 地理围栏预警
     */
    TOUCH_GEO_FENCING_WARNING(3, "fencing", "地理围栏触碰预警"),

    /**
     * 偏航预警
     */
    DIVERGE_WARNING(4, "diverge", "偏航预警"),

    /**
     * 司机离线预警
     */
    OFFLINE_WARNING(5, "offline", "司机设备离线预警"),

    /**
     * 超速预警
     */
    OVER_SPEED_WARNING(6, "overSpeed", "超速预警"),
    /**
     * 疲劳驾驶预警
     */
    TIRED_DRIVING_WARNING(7, "tiredDriving", "疲劳驾驶预警"),
    ;

    private final Integer code;
    private final String name;
    private final String desc;

    public static WarningTypeEnum fromCode(Integer code) {
        return Arrays.stream(values()).filter(e -> e.code.equals(code)).findFirst().orElseThrow(IllegalArgumentException::new);
    }

    public static WarningTypeEnum fromName(String name) {
        return Arrays.stream(values()).filter(e -> e.name.equals(name)).findFirst().orElseThrow(IllegalArgumentException::new);
    }
}
