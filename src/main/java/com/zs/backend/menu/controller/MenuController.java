package com.zs.backend.menu.controller;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zs.backend.base.Result;
import com.zs.backend.menu.entity.Menu;
import com.zs.backend.menu.mapper.MenuMapper;
import com.zs.backend.sys.entity.Role;
import com.zs.backend.sys.entity.UserRole;
import com.zs.backend.sys.mapper.RoleMapper;
import com.zs.backend.sys.mapper.UserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author MybatisGenerator
 * @since 2020-12-18
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Autowired
    private RoleMapper roleMapper;

    @GetMapping("/getMenus")
    public Result getMenuList(){
        // 查询所有菜单
        QueryWrapper<Menu> menuQueryWrapper = new QueryWrapper<Menu>()
                .eq(Menu.DEL, 0).orderByAsc(Menu.SORT);

        List<Menu> menuList = menuMapper.selectList(menuQueryWrapper);

        List<Menu> menus = this.auditMenu(menuList);

        return Result.result(menus);
    }


    private static List<Menu> auditMenu(List<Menu> menus) {
        Map<String, Menu> idAndMenu = new HashMap<>();
        for(Menu menu: menus){
            String menuName = menu.getMenuName();
            if(hasRole(menuName)){
                if(idAndMenu == null || idAndMenu.size() == 0){
                    if(StringUtils.isEmpty(menu.getParentId())){
                        idAndMenu.put(menu.getId(), menu);
                    }else{
                        Menu menuTemp = new Menu();
                        menuTemp.getChildren().add(menu);
                        idAndMenu.put(menu.getParentId(), menuTemp);
                    }
                    continue;
                }

                if(StringUtils.isEmpty(menu.getParentId())){
                    if(idAndMenu.get(menu.getId()) != null){
                        Menu menu1 = idAndMenu.get(menu.getId());
                        menu.setChildren(menu1.getChildren());
                        menu1 = menu;
                        idAndMenu.put(menu.getId(), menu1);
                    }else {
                        idAndMenu.put(menu.getId(), menu);
                    }
                }else if(idAndMenu.get(menu.getParentId()) != null){
                    idAndMenu.get(menu.getParentId()).getChildren().add(menu);
                }else {
                    Menu menuTemp = new Menu();
                    menuTemp.getChildren().add(menu);
                    idAndMenu.put(menu.getParentId(), menuTemp);
                }
            }
        }
        return idAndMenu.values().stream().collect(Collectors.toList());
    }

    private static Boolean hasRole(String roleName) {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<String> roleCodes = new ArrayList<>();
        for (GrantedAuthority authority : user.getAuthorities()) {
            roleCodes.add(authority.getAuthority());
        }
        return roleCodes.contains(roleName);
    }

}
