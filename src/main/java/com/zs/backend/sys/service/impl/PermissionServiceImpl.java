package com.zs.backend.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zs.backend.sys.entity.Permis;
import com.zs.backend.sys.mapper.PermissionMapper;
import com.zs.backend.sys.service.IPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zs.backend.user.model.PageVO;
import com.zs.backend.utils.BeanUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author MybatisGenerator
 * @since 2021-01-25
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permis> implements IPermissionService {

    @Override
    public PageVO<Permis> getPermissionPage(Integer pageNum, Integer pageSize, Permis permission) {
        IPage<Permis> permissionIPage = new Page<>(pageNum, pageSize);
        QueryWrapper<Permis> queryWrapper = new QueryWrapper<Permis>()
                .like(permissionIPage != null && StringUtils.isNotBlank(permission.getPermissionName()),
                        Permis.PERMISSION_NAME, permission.getPermissionName());

        IPage<Permis> permissionPage =  this.page(permissionIPage, queryWrapper);
        List<Permis> permissions =
                BeanUtil.beanCopyPropertiesForList(permissionPage.getRecords(), Permis.class);

        PageVO<Permis> vo = new PageVO(permissions, permissionPage.getTotal());
        return vo;
    }

}
