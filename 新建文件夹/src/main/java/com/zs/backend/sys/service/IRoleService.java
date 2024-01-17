package com.zs.backend.sys.service;

import com.zs.backend.sys.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zs.backend.sys.model.RoleRes;
import com.zs.backend.user.model.PageVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author MybatisGenerator
 * @since 2020-12-13
 */
public interface IRoleService extends IService<Role> {

    /**
     * 角色分页查询
     * @param pageNum
     * @param pageSize
     * @param role
     * @return
     */
    PageVO<RoleRes> getRolePage(Integer pageNum,
                                Integer pageSize, Role role);

    /**
     * 更新角色及角色权限关系
     * @param roleId
     * @param permIds
     * @return
     */
    boolean updateRolePerm(String roleId, List<String> permIds);

    /**
     * 删除角色和角色权限关系
     * @param id
     * @return
     */
    boolean deleteById(String id);

}
