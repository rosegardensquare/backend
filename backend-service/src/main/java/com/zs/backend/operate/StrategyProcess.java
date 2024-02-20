package com.zs.backend.operate;


import com.zs.backend.service.strategy.OrderWarnFactory;
import com.zs.backend.service.strategy.WarningTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StrategyProcess {

    @Autowired
    private OrderWarnFactory orderWarnFactory;

    public void test(){
        orderWarnFactory.get(WarningTypeEnum.TOUCH_GEO_FENCING_WARNING).doWarn();
    }
}
