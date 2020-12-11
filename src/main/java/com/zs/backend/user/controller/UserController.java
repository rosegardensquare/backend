package com.zs.backend.user.controller;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zs.backend.user.entity.User;
import com.zs.backend.user.model.PageVO;
import com.zs.backend.user.model.UserReq;
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
    public PageVO<User> userPage(@RequestParam("pageNum") Integer pageNum,
                                 @RequestParam("pageSize") Integer pageSize,
                                 UserReq userReq) {
        PageVO<User> userPageVO =  userService.getUserPage(pageNum, pageSize, userReq);
        log.info("userIPage : {}", JSON.toJSONString(userPageVO));
        return userPageVO;
    }

    @PostMapping("/addUser")
    public void addUser(@RequestBody UserReq userReq) {
        log.info("userIPage : {}", JSON.toJSONString(userReq));
        User user = new User();
        BeanUtils.copyProperties(userReq, user);
        user.setId(IDGenerator.uuid());
        userService.saveOrUpdate(user);
    }

}
