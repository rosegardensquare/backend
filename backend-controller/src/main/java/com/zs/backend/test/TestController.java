package com.zs.backend.test;

import com.zs.backend.Result;
import com.zs.backend.model.dto.user.CommonUserResponse;
import com.zs.backend.model.dto.user.PageVO;
import com.zs.backend.service.ICommonUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@Slf4j
public class TestController {

    @Autowired
    private ICommonUserService userService;

    @RequestMapping("/test")
    public Result test() {
        PageVO<CommonUserResponse> responsePageVO = userService.getUserPage(1,10, null);
        return Result.result("test,ok");
    }

    @RequestMapping("/test2")
    public Result test2() {
        return Result.result("test,ok");
    }

}
