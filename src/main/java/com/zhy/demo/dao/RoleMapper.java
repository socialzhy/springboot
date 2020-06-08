package com.zhy.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhy.demo.entity.po.Role;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoleMapper extends BaseMapper<Role> {
}
