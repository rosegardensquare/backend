package com.zs.backend.user.controller;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zs.backend.user.entity.User;
import com.zs.backend.user.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author MybatisGenerator
 * @since 2020-12-10
 */
@RestController
@RequestMapping("/user/")
@Slf4j
public class UserController {


    @Autowired
    private IUserService userService;

    @GetMapping("/getUserPage")
    public IPage<User> userPage(@RequestParam(required = true, defaultValue = "1") Integer pageNum,
                                @RequestParam(required = true, defaultValue = "1") Integer pageSize
    ) {
        IPage<User> userPage = new Page<>(pageNum, pageSize);
        IPage<User> userIPage =  userService.page(userPage);
        log.info("userIPage : {}", JSON.toJSONString(userIPage));
        return userIPage;
    }

}
