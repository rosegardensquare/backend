package com.zs.backend.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zs.backend.sys.entity.Permis;
import com.zs.backend.sys.model.PermisDto;
import com.zs.backend.user.model.PageVO;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author MybatisGenerator
 * @since 2021-01-25
 */
public interface IPermissionService extends IService<Permis> {

    /**
     * 权限分页
     *
     * @param pageNum
     * @param pageSize
     * @param permission
     * @return
     */
    PageVO<Permis> getPermissionPage(Integer pageNum,
                                     Integer pageSize, Permis permission);

    /**
     * 新增或修改权限
     *
     * @param permission
     * @return
     */
    boolean saveOrUpdatePermi(PermisDto permission);

}
