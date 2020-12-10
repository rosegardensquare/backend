package com.zs.backend.user.controller;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zs.backend.user.entity.User;
import com.zs.backend.user.model.UserModel;
import com.zs.backend.user.service.IUserService;
import com.zs.backend.utils.IDGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author MybatisGenerator
 * @since 2020-12-10
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {


    @Autowired
    private IUserService userService;

    @GetMapping("/getUserPage")
    public IPage<User> userPage(@RequestParam(required = true, defaultValue = "1") Integer pageNum,
                                @RequestParam(required = true, defaultValue = "1") Integer pageSize) {
        IPage<User> userPage = new Page<>(pageNum, pageSize);
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>()
                .orderByDesc("create_time");
        IPage<User> userIPage =  userService.page(userPage, queryWrapper);
        log.info("userIPage : {}", JSON.toJSONString(userIPage));
        return userIPage;
    }

    @PostMapping("/addUser")
    public void addUser(@RequestBody UserModel userModel) {
        log.info("userIPage : {}", JSON.toJSONString(userModel));
        User user = new User();
        BeanUtils.copyProperties(userModel, user);
        user.setId(IDGenerator.uuid());
        userService.saveOrUpdate(user);
    }

}
