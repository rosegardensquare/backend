package com.zs.backend.service.strategy;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 预警工厂类
 */
@Component
@Slf4j
public class OrderWarnFactory {

    @Autowired
    private List<AbstractWarnStrategy> warnStrategyList;

    public AbstractWarnStrategy get(WarningTypeEnum warningTypeEnum) {
        for (AbstractWarnStrategy strategy : warnStrategyList) {
            if (warningTypeEnum == strategy.support()) {
                return strategy;
            }
        }
        throw new RuntimeException("请确认功能");
    }
}
