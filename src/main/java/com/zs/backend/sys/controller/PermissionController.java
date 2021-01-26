package com.zs.backend.sys.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zs.backend.base.Result;
import com.zs.backend.menu.entity.Menu;
import com.zs.backend.sys.entity.Permis;
import com.zs.backend.sys.mapper.PermissionMapper;
import com.zs.backend.sys.service.IPermissionService;
import com.zs.backend.user.model.PageVO;
import com.zs.backend.utils.IDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author MybatisGenerator
 * @since 2021-01-25
 */
@RestController
@RequestMapping("/sys/permission")
public class PermissionController {

    @Autowired
    private IPermissionService permissionService;
    @Autowired
    private PermissionMapper permissionMapper;

    @GetMapping("/getPermiPage")
    public Result permiPage(@RequestParam("pageNum") Integer pageNum,
                           @RequestParam("pageSize") Integer pageSize,
                            Permis permission) {
        PageVO<Permis> vo =  permissionService.getPermissionPage(pageNum, pageSize, permission);
        return Result.result(vo);
    }

    @PostMapping("/addPermi")
    public Result addPermi(@RequestBody Permis permission) {
        if(StringUtils.isEmpty(permission.getId())){
            permission.setId(IDGenerator.uuid());
        }
        boolean result = permissionService.saveOrUpdate(permission);
        return Result.result(result);
    }

    @GetMapping("/deletePermi")
    public Result deletePermi(String id) {
        return Result.result(permissionService.removeById(id));
    }


    @GetMapping("/getMenus")
    public Result getMenuList(){
        // 查询所有菜单
        QueryWrapper<Permis> menuQueryWrapper = new QueryWrapper<Permis>()
                .eq(Menu.DEL, 0).orderByAsc(Menu.SORT);

        List<Permis> menuList = permissionMapper.selectList(menuQueryWrapper);

        List<Permis> menus = auditMenu(menuList);

        return Result.result(menus);
    }


    private static List<Permis> auditMenu(List<Permis> menus) {
        Map<String, Permis> idAndMenu = new HashMap<>();
        for(Permis menu: menus){
            String menuName = menu.getPermissionName();
            if(hasRole(menuName)){
                if(idAndMenu == null || idAndMenu.size() == 0){
                    if(StringUtils.isEmpty(menu.getParentId())){
                        idAndMenu.put(menu.getId(), menu);
                    }else{
                        Permis menuTemp = new Permis();
                        menuTemp.getChildren().add(menu);
                        idAndMenu.put(menu.getParentId(), menuTemp);
                    }
                    continue;
                }

                if(StringUtils.isEmpty(menu.getParentId())){
                    if(idAndMenu.get(menu.getId()) != null){
                        Permis menu1 = idAndMenu.get(menu.getId());
                        menu.setChildren(menu1.getChildren());
                        menu1 = menu;
                        idAndMenu.put(menu.getId(), menu1);
                    }else {
                        idAndMenu.put(menu.getId(), menu);
                    }
                }else if(idAndMenu.get(menu.getParentId()) != null){
                    idAndMenu.get(menu.getParentId()).getChildren().add(menu);
                }else {
                    Permis menuTemp = new Permis();
                    menuTemp.getChildren().add(menu);
                    idAndMenu.put(menu.getParentId(), menuTemp);
                }
            }
        }
        return idAndMenu.values().stream().collect(Collectors.toList());
    }

    private static Boolean hasRole(String roleName) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<String> roleCodes = new ArrayList<>();
        for (GrantedAuthority authority : user.getAuthorities()) {
            roleCodes.add(authority.getAuthority());
        }
        return roleCodes.contains(roleName);
    }



    @GetMapping("/getMenusByParentId")
    public Result getMenusByParentId(@RequestParam("parentId") String parentId){

        QueryWrapper<Permis> menuQueryWrapper = new QueryWrapper<Permis>()
                .eq(Permis.DEL, 0).eq(Permis.PARENT_ID, parentId).orderByAsc(Menu.SORT);
        List<Permis> menuList = permissionMapper.selectList(menuQueryWrapper);
        return Result.result(menuList);
    }

}
