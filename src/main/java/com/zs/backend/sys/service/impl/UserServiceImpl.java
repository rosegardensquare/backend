package com.zs.backend.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zs.backend.sys.entity.User;
import com.zs.backend.sys.entity.UserRole;
import com.zs.backend.sys.mapper.UserMapper;
import com.zs.backend.sys.model.UserReq;
import com.zs.backend.sys.model.UserResponse;
import com.zs.backend.sys.service.IUserRoleService;
import com.zs.backend.sys.service.IUserService;
import com.zs.backend.user.model.CommonUserReq;
import com.zs.backend.user.model.PageVO;
import com.zs.backend.utils.BeanUtil;
import com.zs.backend.utils.EncodePasswordUtils;
import com.zs.backend.utils.IDGenerator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author MybatisGenerator
 * @since 2020-12-13
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private IUserRoleService userRoleService;

    @Override
    public PageVO<UserResponse> getUserPage(Integer pageNum, Integer pageSize, CommonUserReq userReq) {
        IPage<User> userPage = new Page<>(pageNum, pageSize);
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>()
                .like(userPage != null && StringUtils.isNotBlank(userReq.getQueryName()),
                        User.USER_NAME, userReq.getQueryName())
                .orderByDesc(User.UPDATE_TIME);

        IPage<User> userIPage = this.page(userPage, queryWrapper);
        List<UserResponse> userResponses =
                BeanUtil.beanCopyPropertiesForList(userIPage.getRecords(), UserResponse.class);

        PageVO<UserResponse> userPageVO = new PageVO(userResponses, userIPage.getTotal());
        return userPageVO;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveOrUpdateUser(UserReq userReq) {
        User user = new User();
        BeanUtils.copyProperties(userReq, user);
        if (StringUtils.isEmpty(user.getId())) {
            user.setId(IDGenerator.uuid());
            user.setPassWord(EncodePasswordUtils.encodePassword(user.getRealPwd()));
            // 新增或者添加角色
            UserRole userRole = new UserRole();
            userRole.setId(IDGenerator.uuid());
            userRole.setUserId(user.getId());
            userRole.setRoleId(userReq.getRoleId());
            userRoleService.save(userRole);
        }
        this.saveOrUpdate(user);
        return true;
    }
}
