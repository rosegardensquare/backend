package com.zs.backend.controller.user;

import com.zs.backend.entity.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserController {


    @RequestMapping("getUser/{id}")
    public User GetUser(@PathVariable int id) {
        return new User();
    }
}
