package com.zhy.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhy.demo.dao.PermissionMapper;
import com.zhy.demo.entity.po.Permission;
import com.zhy.demo.service.IPermissionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionService extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {


    @Override
    public List<Permission> selectByUserId(int userId) {
        return this.baseMapper.selectByUserId(userId);
    }
}
