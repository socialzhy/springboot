package com.zhy.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhy.demo.entity.po.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
