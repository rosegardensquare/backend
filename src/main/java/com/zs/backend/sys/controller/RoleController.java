package com.zs.backend.sys.controller;


import com.zs.backend.base.Result;
import com.zs.backend.sys.entity.Role;
import com.zs.backend.sys.model.RoleRequest;
import com.zs.backend.sys.model.RoleRes;
import com.zs.backend.sys.service.IPermissionService;
import com.zs.backend.sys.service.IRolePermService;
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
        PageVO<RoleRes> vo =  roleService.getRolePage(pageNum, pageSize, role);
        return Result.result(vo);
    }

    @PostMapping("/addRole")
    public Result addRole(@RequestBody RoleRequest role) {
        if(StringUtils.isEmpty(role.getId())){
            role.setId(IDGenerator.uuid());
        }
        boolean result = roleService.saveOrUpdate(role);
        roleService.updateRolePerm(role.getId(), role.getPermisIds());
        return Result.result(result);
    }

    @GetMapping("/deleteRole")
    public Result deleteRole(@RequestParam("id") String id) {
        return Result.result(roleService.deleteById(id));
    }


    @GetMapping("/getRoles")
    public Result getRoles(){
        return Result.result(roleService.list());
    }

}
