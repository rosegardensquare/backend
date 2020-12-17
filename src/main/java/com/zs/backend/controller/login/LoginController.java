package com.zs.backend.controller.login;

import com.alibaba.fastjson.JSON;
import com.zs.backend.base.Result;
import com.zs.backend.sys.entity.User;
import com.zs.backend.user.entity.CommonUser;
import com.zs.backend.user.service.ICommonUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@Slf4j
public class LoginController {


    @RequestMapping("/login")
    public Result login(@RequestBody User userModel) {
      log.info("LoginController. login. param: {} ", JSON.toJSONString(userModel));
        return Result.result("ok");

    }

}
