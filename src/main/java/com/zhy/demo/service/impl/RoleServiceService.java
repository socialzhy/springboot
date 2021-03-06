package com.zhy.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhy.demo.dao.RoleMapper;
import com.zhy.demo.entity.form.RoleForm;
import com.zhy.demo.entity.po.Role;
import com.zhy.demo.service.IRoleService;
import org.springframework.stereotype.Service;


@Service
public class RoleServiceService extends ServiceImpl<RoleMapper, Role> implements IRoleService {
    @Override
    public Integer add(RoleForm form) {
        return this.baseMapper.insert(form.toPo(Role.class));
    }
}
