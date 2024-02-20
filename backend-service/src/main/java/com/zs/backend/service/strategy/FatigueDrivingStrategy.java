package com.zs.backend.service.strategy;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 司机疲劳驾驶预警策略
 */
@Slf4j
@Component
public class FatigueDrivingStrategy extends AbstractWarnStrategy {

    @Override
    public Map<String, String> getCacheMap() {
        Map<String, String> allCacheMap = new HashMap<>();
        return allCacheMap;
    }

    @Override
    public List warnHandle(Map<Long, List> map) {
        return null;
    }

    @Override
    public void saveWarnInfo(List orderDTOList) {

    }

    @Override
    public WarningTypeEnum support() {
        return WarningTypeEnum.TIRED_DRIVING_WARNING;
    }

}
