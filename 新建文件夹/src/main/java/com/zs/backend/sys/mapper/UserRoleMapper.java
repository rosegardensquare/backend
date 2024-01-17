package com.zs.backend.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zs.backend.sys.entity.UserRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author MybatisGenerator
 * @since 2020-12-13
 */
@Repository
public interface UserRoleMapper extends BaseMapper<UserRole> {

    /**
     * 根据用户id 查询用户角色
     *
     * @param userIds
     * @return
     */
    List<UserRole> selectByUserIds(@Param("userIds") List<String> userIds);

}
