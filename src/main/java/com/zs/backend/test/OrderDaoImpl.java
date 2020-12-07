package com.zs.backend.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import com.zs.backend.mapper.OrderMapper;
import com.zs.backend.test.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * <p>
 * 运单 服务实现类
 * </p>
 *
 * @author mybatis-plus-generator
 * @since 2019-10-21
 */
@Service
public class OrderDaoImpl extends ServiceImpl<OrderMapper, Order> implements IOrderDao {

}
