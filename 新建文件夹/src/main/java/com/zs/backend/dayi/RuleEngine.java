package com.zs.backend.dayi;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;
import com.ql.util.express.IExpressContext;
import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RuleEngine {

    private static ExpressRunner runner = new ExpressRunner();
    /**
     * 入参对象字段和公式参数的映射关系
     */
    private static BiMap<String,String> paramMapping;


    /**
     * 规则引擎全局设置
     * @throws Exception
     */
    @PostConstruct
    public void init() throws Exception {
        //短路运算
        runner.setShortCircuit(true);
        log.info("添加添加操作符别名 且=>and");
        runner.addOperatorWithAlias("且","and",null);
        log.info("添加添加操作符别名 或=>or");
        runner.addOperatorWithAlias("或","or",null);

        paramMapping= HashBiMap.create();
        paramMapping.put("货物单位","goodsWeightUnitCode");
        paramMapping.put("运输里程","mileage");
        paramMapping.put("公里单价","mileagePrice");
        paramMapping.put("运单总价","totalAmount");

        paramMapping.put("货主签收量","signCapacity");
        paramMapping.put("abs1","signCapacityAbs_1");
        paramMapping.put("abs2","signCapacityAbs_2");
        paramMapping.put("abs3","signCapacityAbs_3");
        paramMapping.put("abs4","signCapacityAbs_4");

        paramMapping.put("司机提货量","driverTakeCapacity");
        paramMapping.put("司机卸货量","driverUnloadCapacity");
        paramMapping.put("货主提货量","shipperTakeCapacity");
        paramMapping.put("货主卸货量","shipperUnloadCapacity");

        log.info("入参对象字段和公式参数的映射关系:{}",paramMapping.toString());
    }

    public ExpressRunner getExpressRunner(){
        return runner;
    }


    public Object execute(String express,Object param) throws Exception {
        log.info("执行表达式 {} param表达式入参:{}",express, JSON.toJSONString(param));
        IExpressContext<String, Object> context = getContext(express,param);
        log.info("执行表达式 {} 表达式入参:{}",express,context.toString());
        Object execute = runner.execute(express, context, null, true, false);
        log.info("执行表达式 {} 运行结果:{}",express,execute);
        return execute;
    }

    private static IExpressContext<String, Object> getContext(String express, Object param)
        throws Exception {
        IExpressContext<String, Object> context = new DefaultContext<>();
        String[] ruleItems = express.split("且");
        for(String ruleItem : ruleItems){
            String[] varNames = runner.getInstructionSetFromLocalCache(ruleItem).getOutAttrNames();
            for(String var: varNames){
                if( !paramMapping.containsKey(var)){
                    log.warn("找不到规则对应入参:{}",var);
                    continue;
                }
                String fieldName = paramMapping.get(var);
                Object val = PropertyUtils.getProperty(param, fieldName);
                context.put(var,val);
            }
        }

        return context;
    }

}
