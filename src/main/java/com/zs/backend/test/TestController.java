package com.zs.backend.test;

import com.alibaba.fastjson.JSON;
import com.zs.backend.base.Result;
import com.zs.backend.config.IgnoreUrlsConfig;
import com.zs.backend.sys.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Slf4j
public class TestController {

    @RequestMapping("/hello")
    public Result test() {
        return Result.result("ok");

    }

}
