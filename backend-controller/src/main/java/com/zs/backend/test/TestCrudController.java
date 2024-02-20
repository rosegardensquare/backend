package com.zs.backend.test;


import com.zs.backend.service.ICommonUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/crud")
@Slf4j
public class TestCrudController {

    @Autowired
    private ICommonUserService commonUserService;

    @GetMapping("/test")
    public Object test(){
        int count = commonUserService.count();
        return count;
    }


}
