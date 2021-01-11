package com.zs.backend.sys.controller;


import com.zs.backend.base.Result;
import com.zs.backend.sys.entity.Role;
import com.zs.backend.sys.service.IRoleService;
import com.zs.backend.user.model.PageVO;
import com.zs.backend.utils.IDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author MybatisGenerator
 * @since 2020-12-13
 */
@RestController
@RequestMapping("/sys/role")
public class RoleController {


    @Autowired
    private IRoleService roleService;

    @GetMapping("/getRolePage")
    public Result rolePage(@RequestParam("pageNum") Integer pageNum,
                           @RequestParam("pageSize") Integer pageSize,
                           Role role) {
        PageVO<Role> vo =  roleService.getRolePage(pageNum, pageSize, role);
        return Result.result(vo);
    }

    @PostMapping("/addRole")
    public Result addRole(@RequestBody Role role) {
        if(StringUtils.isEmpty(role.getId())){
            role.setId(IDGenerator.uuid());
        }
        boolean result = roleService.saveOrUpdate(role);
        return Result.result(result);
    }

    @GetMapping("/deleteRole")
    public Result deleteRole(String id) {
        return Result.result(roleService.removeById(id));
    }

}
