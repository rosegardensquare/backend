package com.zs.backend.controller.login;

import com.alibaba.fastjson.JSON;
import com.zs.backend.user.entity.User;
import com.zs.backend.user.service.IUserService;
import com.zs.backend.user.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@Slf4j
public class LoginController {

    @Autowired
    private IUserService userService;

    @RequestMapping("login")
    public void login(@RequestBody User userModel) {
      log.info("LoginController. login. param: {} ", JSON.toJSONString(userModel));
      
    }

}
