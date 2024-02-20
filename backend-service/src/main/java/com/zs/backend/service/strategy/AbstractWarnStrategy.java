package com.zs.backend.service.strategy;

import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public abstract class AbstractWarnStrategy {

    /**
     * 1.获取缓存中的预警信息
     *
     * @return
     */
    public abstract Map<String, String> getCacheMap();

    /**
     * 2.预警逻辑
     *
     * @param map
     * @return
     */
    public abstract List warnHandle(Map<Long, List> map);

    /**
     * 3.保存预警信息
     *
     * @param orderDTOList
     */
    public abstract void saveWarnInfo(List orderDTOList);

    public void doWarn() {
        log.info("AbstractWarnStrategy.doWarn...");
        // 1:获取缓存对象
        Map<String, String> cacheDTOMap = this.getCacheMap();
        // 2:逻辑处理
        List orderDTOList = this.warnHandle(null);

    }

    public abstract WarningTypeEnum support();

}
