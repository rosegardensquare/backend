package com.zs.backend.user.controller;


import com.alibaba.fastjson.JSON;
import com.zs.backend.base.Result;
import com.zs.backend.user.entity.CommonUser;
import com.zs.backend.user.model.CommonUserReq;
import com.zs.backend.user.model.CommonUserResponse;
import com.zs.backend.user.model.PageVO;
import com.zs.backend.user.service.ICommonUserService;
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
public class CommonUserController {


    @Autowired
    private ICommonUserService userService;

    @GetMapping("/getUserPage")
    public Result userPage(@RequestParam("pageNum") Integer pageNum,
                           @RequestParam("pageSize") Integer pageSize,
                           CommonUserReq userReq) {
        PageVO<CommonUserResponse> userPageVO =  userService.getUserPage(pageNum, pageSize, userReq);
        log.info("userIPage : {}", JSON.toJSONString(userPageVO));
        return Result.result(userPageVO);
    }

    @PostMapping("/addUser")
    public Result addUser(@RequestBody CommonUserReq userReq) {
        log.info("userReq : {}", JSON.toJSONString(userReq));
        CommonUser user = new CommonUser();
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
        CommonUser user = userService.getById(id);
        // todo 公共异常
        user.setDel(del);
        return Result.result(userService.saveOrUpdate(user));
    }

    @GetMapping("/test")
    public void test() {
        userService.test();
    }
}
