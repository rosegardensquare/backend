package com.zs.backend.dayi.controller;

import com.zs.backend.base.Result;
import com.zs.backend.dayi.service.IDayiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dayi")
@Slf4j
public class DayiController {


    @Autowired
    private IDayiService dayiService;

    @RequestMapping("/test")
    public Result test() {
        try {
            dayiService.test();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.result("ok");

    }


}
