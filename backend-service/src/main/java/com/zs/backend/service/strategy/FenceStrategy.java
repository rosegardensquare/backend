package com.zs.backend.service.strategy;

import com.alibaba.fastjson.JSON;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


/**
 * 地理围栏预警策略
 */
@Slf4j
@Component
public class FenceStrategy extends AbstractWarnStrategy {

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
        return WarningTypeEnum.DIVERGE_WARNING;
    }

}
