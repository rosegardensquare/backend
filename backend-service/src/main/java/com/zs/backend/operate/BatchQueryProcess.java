package com.zs.backend.operate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class BatchQueryProcess {

    public static final Integer batchSize = 1000;

    /**
     * 分批查询数据
     */
    public void batchQuery(){
//        Long minId = 0L;
//        List<Long> orderIds = new ArrayList<>();
//        while (true){
//            List orders = orderService.queryByIds(minId, batchSize);
//            if(orders != null || orders.size() == 0){
//                break;
//            }
//            orderIds.addAll(orders.stream().map(OrderDTO::getId).collect(Collectors.toList()));
//            minId = orderIds.get(orderIds.size() -1);
//        }
    }

}
