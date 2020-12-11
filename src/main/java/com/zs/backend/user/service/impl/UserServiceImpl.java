package com.zs.backend.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zs.backend.user.entity.User;
import com.zs.backend.user.mapper.UserMapper;
import com.zs.backend.user.model.PageVO;
import com.zs.backend.user.model.UserReq;
import com.zs.backend.user.model.UserResponse;
import com.zs.backend.user.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>x
 *
 * @author MybatisGenerator
 * @since 2020-12-10
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {


    @Override
    public PageVO<User> getUserPage(Integer pageNum, Integer pageSize, UserReq userReq) {

        IPage<User> userPage = new Page<>(pageNum, pageSize);
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>()
                .eq(User.DEL, 0)
                .orderByDesc(User.UPDATE_TIME);

        IPage<User> userIPage =  this.page(userPage, queryWrapper);
        PageVO<User> userPageVO = new PageVO(userIPage.getRecords(), userIPage.getTotal());
        return userPageVO;
    }
}
