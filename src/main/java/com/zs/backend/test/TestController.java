package com.zs.backend.test;

import com.alibaba.fastjson.JSON;
import com.zs.backend.entity.User;
import com.zs.backend.model.UserModel;
import com.zs.backend.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    @Autowired
    private UserService userService;

    //private static Logger logger = LoggerFactory.getLogger(LoginController.class);
    @RequestMapping("/")
    public void login(@RequestBody User userModel) {
        log.info("------" + JSON.toJSONString(userModel));
        String a = "{'id':1, 'name':'10'}";
        User u = JSON.parseObject(a, UserModel.class);
        log.info("------" + JSON.toJSONString(u));
        userService.saveOrUpdate(u);

        User user = userService.findById(1);
        log.info("###########" + JSON.toJSONString(user));

    }

}
