package com.zs.backend.test.controller;

import com.zs.backend.base.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@Slf4j
public class TestController {




    @RequestMapping("/test")
    public Result test() {

        return Result.result("ok");

    }


}
