package com.zhy.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhy.demo.entity.po.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PermissionMapper  extends BaseMapper<Permission> {

    @Select("SELECT\n" +
            "p.* \n" +
            "FROM\n" +
            "cfg_user u\n" +
            "LEFT JOIN cfg_user_role ur ON u.id = ur.user_id\n" +
            "LEFT JOIN cfg_role r ON ur.role_id = r.id\n" +
            "LEFT JOIN cfg_role_permission rp ON r.id = rp.role_id\n" +
            "LEFT JOIN cfg_permission p ON rp.permission_id = p.id\n" +
            "where u.id=#{userId}")
    List<Permission> selectByUserId(@Param("userId") int userId);
}
