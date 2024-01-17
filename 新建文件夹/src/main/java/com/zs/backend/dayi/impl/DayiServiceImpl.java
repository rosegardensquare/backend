package com.zs.backend.dayi.impl;

import com.alibaba.fastjson.JSON;
import com.zs.backend.base.BaseException;
import com.zs.backend.dayi.PlatformRuleEntity;
import com.zs.backend.dayi.PlatformRuleFireOperationEnum;
import com.zs.backend.dayi.PlatformRuleItemResult;
import com.zs.backend.dayi.PlatformRuleResult;
import com.zs.backend.dayi.RuleEngine;
import com.zs.backend.dayi.TariffRuleCheckDTO;
import com.zs.backend.dayi.TariffRuleDetail;
import com.zs.backend.dayi.TariffRuleDetailDTO;
import com.zs.backend.dayi.service.IDayiService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DayiServiceImpl implements IDayiService {

    @Autowired
    private RuleEngine engine;

    @Override
    public void test() throws Exception {
        PlatformRuleResult result = PlatformRuleResult.builder()
            .fireOperation(PlatformRuleFireOperationEnum.NO_OP).build();


        // data ====== log.info("货主运价规则校验参数：{}", JSON.toJSONString(cmd));
        TariffRuleCheckDTO data = new TariffRuleCheckDTO();
        // TODO
        data.setGoodsWeightUnit("10");
        data.setGoodsWeightUnitCode(10);

        BigDecimal mileage = new BigDecimal("1.25");
        data.setMileage(mileage);
        BigDecimal mileagePrice = new BigDecimal("10.400");
        data.setMileagePrice(mileagePrice);

        BigDecimal shipperPrice = new BigDecimal("13.00");
        data.setShipperPrice(shipperPrice);

        BigDecimal totalAmount = new BigDecimal("68.90");
        data.setTotalAmount(totalAmount);

        BigDecimal signCapacity = new BigDecimal("5.300");
        data.setSignCapacity(signCapacity);

        BigDecimal shipperUnloadCapacity = new BigDecimal("6.000");
        data.setShipperUnloadCapacity(shipperUnloadCapacity);

        BigDecimal shipperTakeCapacity = new BigDecimal("5.100");
        data.setShipperTakeCapacity(shipperTakeCapacity);

        BigDecimal driverUnloadCapacity = new BigDecimal("0");
        data.setDriverUnloadCapacity(driverUnloadCapacity);

        BigDecimal driverTakeCapacity = new BigDecimal("0");
        data.setDriverTakeCapacity(driverTakeCapacity);

        data.setSignCapacityAbs_1(data.getShipperUnloadCapacity().subtract(data.getShipperTakeCapacity()).abs());
        data.setSignCapacityAbs_2(data.getShipperUnloadCapacity().subtract(data.getSignCapacity()).abs());
        data.setSignCapacityAbs_3(data.getShipperTakeCapacity().subtract(data.getDriverTakeCapacity()).abs());
        data.setSignCapacityAbs_4(data.getShipperUnloadCapacity().subtract(data.getDriverUnloadCapacity()).abs());


        // 根据场景查询
        // log.info("根据场景查询规则：{}", JSON.toJSONString(platformRules));
        List<PlatformRuleEntity> platformRules = new ArrayList<>();
        // TODO
        PlatformRuleEntity platformRuleEntity_1 = new PlatformRuleEntity();
        platformRuleEntity_1.setRuleDetail("{\"ruleDetail\": [{\"action\": 3, \"preRule\": \"货物单位 = 10\", \"tariffRule\": \"（货主卸货量-货主提货量）绝对值 < 2 或 （货主提货量-司机提货量）绝对值 < 1\"}]}");
        platformRules.add(platformRuleEntity_1);

//        PlatformRuleEntity platformRuleEntity_2 = new PlatformRuleEntity();
//        platformRuleEntity_2.setRuleDetail("{\"ruleDetail\": [{\"action\": 1, \"preRule\": \"货物单位 = 10\", \"tariffRule\": \"（货主卸货量-货主提货量）绝对值 < 2 或 （货主提货量-司机提货量）绝对值 < 1\"}]}");
//        platformRules.add(platformRuleEntity_2);

        List<PlatformRuleItemResult> itemResults = new ArrayList<>();

        for(PlatformRuleEntity platformRule : platformRules){
            itemResults.add(checkRuleDetail(platformRule, data, result));

//            replaceTariffRule(platformRule);
//            TariffRuleDetailDTO tariffRuleDetailDTO = JSON.parseObject(platformRule.getRuleDetail(), TariffRuleDetailDTO.class);
//            if(checkTariffRule(tariffRuleDetailDTO.getRuleDetail(), data, result)){
//                result.setRuleId(platformRule.getId());
//                return ;
//            }
        }
        result.setItemResults(itemResults);

        log.info("结果：{}", this.isis(result));

    }

    private boolean isis(PlatformRuleResult result){

        List<PlatformRuleItemResult> itemResults = result.getItemResults();
        List<Integer> rawIds = itemResults.stream().map(PlatformRuleItemResult::getFireOperationCode).collect(
            Collectors.toList());
        if(rawIds.contains(PlatformRuleFireOperationEnum.FORBIDDEN.getCode())){
            throw new BaseException("order.shipper.signCapacity.verify.error");
        }


        if(rawIds.contains(PlatformRuleFireOperationEnum.SIGN_RISK.getCode())){
            return true;
        }
        return false;
    }

    private PlatformRuleItemResult checkRuleDetail(PlatformRuleEntity platformRule, TariffRuleCheckDTO data, PlatformRuleResult result)
        throws Exception {
        PlatformRuleItemResult platformRuleItemResult = new PlatformRuleItemResult();
        replaceTariffRule(platformRule);
        TariffRuleDetailDTO tariffRuleDetailDTO = JSON.parseObject(platformRule.getRuleDetail(), TariffRuleDetailDTO.class);
        if(checkTariffRule(tariffRuleDetailDTO.getRuleDetail(), data, result)){
            platformRuleItemResult.setFireOperationCode(result.getFireOperation().getCode());
        }
        return platformRuleItemResult;
    }

    private void replaceTariffRule(PlatformRuleEntity platformRule){
        String ruleDetail = platformRule.getRuleDetail().replaceAll("（货主卸货量-货主提货量）绝对值 ", "abs1")
            .replaceAll("（货主卸货量-货主签收量）绝对值", "abs2")
            .replaceAll("（货主提货量-司机提货量）绝对值", "abs3")
            .replaceAll("（货主卸货量-司机卸货量）绝对值", "abs4")
        ;
        platformRule.setRuleDetail(ruleDetail);
    }

    public boolean checkTariffRule(List<TariffRuleDetail> dbRuleDetails, TariffRuleCheckDTO param, PlatformRuleResult result) throws Exception{
        for(TariffRuleDetail dbRuleDetail : dbRuleDetails){
            log.info("数据库规则信息:{}, 参数：{}", JSON.toJSONString(dbRuleDetail), JSON.toJSONString(param));
            // 前置规则校验：货物单位
            if(!enginCheckPreRuleParam(param, dbRuleDetail)){
                continue;
            }
            // 规则校验
            if(this.doCheckTariffRule(dbRuleDetail, param, result)){
                return true;
            }
        }
        return false;
    }

    private boolean enginCheckPreRuleParam(TariffRuleCheckDTO param, TariffRuleDetail dbRuleDetail) throws Exception{
        param.setGoodsWeightUnitCode(Integer.parseInt(param.getGoodsWeightUnit()));
        Object preRuleCheckResult = engine.execute(dbRuleDetail.getPreRule().replaceAll("=", "=="), param);
        log.info("前置条件校验结果:{}", JSON.toJSONString(preRuleCheckResult));
        if(Boolean.FALSE.equals(preRuleCheckResult)){
            return false;
        }
        return true;
    }




    public boolean doCheckTariffRule(TariffRuleDetail dbRuleDetail, TariffRuleCheckDTO param, PlatformRuleResult result)
        throws Exception {
        // 规则校验
        String dbTariffRules = dbRuleDetail.getTariffRule();
        String[] splitTariffRules = dbTariffRules.split("或");
        log.info("开始进行指标配置校验.数据库规则:{}, 拆分为多个规则：{}", JSON.toJSONString(dbTariffRules), JSON.toJSONString(splitTariffRules));

        // 转化为多个规则
        for(String splitTariffRule : splitTariffRules){
            Object tariffRuleResult = engine.execute(this.replaceTariffRule(splitTariffRule), param);
            log.info("指标配置校验结果:{}", JSON.toJSONString(tariffRuleResult));
            if(Boolean.TRUE.equals(tariffRuleResult)){
                result.setFireOperation(PlatformRuleFireOperationEnum.valueOf(dbRuleDetail.getAction()));
                log.info("指标配置校验返回结果:result：{}, dbRuleDetail:{}", JSON.toJSONString(result), JSON.toJSONString(dbRuleDetail));
                return true;
            }
        }
        return false;
    }

    private String replaceTariffRule(String splitTariffRule){
        String  replaceTariffRule = splitTariffRule
            .replaceAll(">=", "#").replaceAll("<=", "&")
            .replaceAll("=", "==")
            .replaceAll("#", ">=")
            .replaceAll("&", "<=");
        return replaceTariffRule.trim();
    }

}
