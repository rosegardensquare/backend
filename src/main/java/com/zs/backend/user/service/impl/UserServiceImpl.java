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
import com.zs.backend.utils.BeanUtil;
import com.zs.backend.utils.DateUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public PageVO<UserResponse> getUserPage(Integer pageNum, Integer pageSize, UserReq userReq) {

        IPage<User> userPage = new Page<>(pageNum, pageSize);
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>()
                .orderByDesc(User.UPDATE_TIME);

        IPage<User> userIPage =  this.page(userPage, queryWrapper);
        List<UserResponse> userResponses = BeanUtil.beanCopyPropertiesForList(userIPage.getRecords(), UserResponse.class);

        PageVO<UserResponse> userPageVO = new PageVO(userResponses, userIPage.getTotal());
        return userPageVO;
    }
}
