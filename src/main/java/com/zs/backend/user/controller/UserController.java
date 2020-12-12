package com.zs.backend.user.controller;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zs.backend.base.Result;
import com.zs.backend.user.entity.User;
import com.zs.backend.user.model.PageVO;
import com.zs.backend.user.model.UserReq;
import com.zs.backend.user.model.UserResponse;
import com.zs.backend.user.service.IUserService;
import com.zs.backend.utils.IDGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
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
    public Result userPage(@RequestParam("pageNum") Integer pageNum,
                           @RequestParam("pageSize") Integer pageSize,
                           UserReq userReq) {
        PageVO<UserResponse> userPageVO =  userService.getUserPage(pageNum, pageSize, userReq);
        log.info("userIPage : {}", JSON.toJSONString(userPageVO));
        return Result.result(userPageVO);
    }

    @PostMapping("/addUser")
    public Result addUser(@RequestBody UserReq userReq) {
        log.info("userReq : {}", JSON.toJSONString(userReq));
        User user = new User();
        BeanUtils.copyProperties(userReq, user);
        if(StringUtils.isEmpty(user.getId())){
            user.setId(IDGenerator.uuid());
        }
        boolean result = userService.saveOrUpdate(user);
        return Result.result(result);
    }

    @GetMapping("/deleteUser")
    public Result deleteUser(String id) {
        log.info("deleteUser : {}", id);
        return Result.result(userService.removeById(id));
    }
    @GetMapping("/updateUserStatus")
    public Result updateUserStatus(String id, boolean del) {
        log.info("updateUserStatus : {}", id);
        User user = userService.getById(id);
        // todo 异常
        user.setDel(del);
        return Result.result(userService.saveOrUpdate(user));
    }
}
