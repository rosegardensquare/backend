package com.zs.backend.sys.mapper;

import com.zs.backend.sys.entity.Permis;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zs.backend.sys.model.PermisDto;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author MybatisGenerator
 * @since 2021-01-25
 */
@Repository
public interface PermissionMapper extends BaseMapper<Permis> {

    List<PermisDto> getByRoleIds(@Param("roleIds") List<String> roleIds);

}
