package com.zhy.demo.service;

import com.zhy.demo.entity.po.Permission;

import java.util.List;

public interface IPermissionService {

    List<Permission> selectByUserId(int userId);
}
