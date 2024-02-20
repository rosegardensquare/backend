package com.zs.backend.test;


import com.zs.backend.operate.BatchQueryProcess;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/crud")
@Slf4j
public class TestBatchQueryController {

    @Autowired
    private BatchQueryProcess batchQueryProcess;

    @GetMapping("/test")
    public void test(){
        batchQueryProcess.batchQuery();
    }

}
