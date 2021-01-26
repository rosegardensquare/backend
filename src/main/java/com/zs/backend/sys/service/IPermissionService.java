package com.zs.backend.sys.service;

import com.zs.backend.sys.entity.Permis;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zs.backend.user.model.PageVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author MybatisGenerator
 * @since 2021-01-25
 */
public interface IPermissionService extends IService<Permis> {

    PageVO<Permis> getPermissionPage(Integer pageNum,
                                     Integer pageSize, Permis permission);

}
