package com.zs.backend.controller.login;

import com.alibaba.fastjson.JSON;
import com.zs.backend.entity.User;
import com.zs.backend.model.UserModel;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@Slf4j
public class LoginController {

    //private static Logger logger = LoggerFactory.getLogger(LoginController.class);


    @RequestMapping("login")
    public void login(@RequestBody User userModel) {
        log.info("------" + JSON.toJSONString(userModel));
        String a = "{'userName':'1'}";


        User u = JSON.parseObject(a, UserModel.class);
        log.info("------" + JSON.toJSONString(u));
    }

}
