package com.zhy.demo.service;


import com.zhy.demo.entity.form.UserForm;
import com.zhy.demo.entity.po.User;

public interface IUserService {

    User getByUserId(Integer userId);

    Integer add(UserForm form);

    Boolean updateDisable(Integer userId, Integer isDisabled);
}
