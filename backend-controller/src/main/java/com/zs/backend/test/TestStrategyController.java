package com.zs.backend.test;


import com.zs.backend.operate.StrategyProcess;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@Slf4j
public class TestStrategyController {

    @Autowired
    private StrategyProcess strategyProcess;

    @GetMapping("/strategy")
    public void test(){
        strategyProcess.test();
    }

}
