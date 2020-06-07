package com.zhy.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhy.demo.dao.UserMapper;
import com.zhy.demo.entity.form.UserForm;
import com.zhy.demo.entity.po.User;
import com.zhy.demo.service.IUserService;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class UserService extends ServiceImpl<UserMapper, User> implements IUserService {
    @Override
    public User getByUserId(Integer userId) {
        return getById(userId);
    }

    @Override
    public Integer add(UserForm form) {
        User user = form.toPo(User.class);
        user.setPwd(BCrypt.hashpw(user.getPwd(), BCrypt.gensalt()));
        return this.baseMapper.insert(user);
    }

    @Override
    public Boolean updateDisable(Integer userId, Integer isDisabled) {
        User user = this.getById(userId);
        boolean flag = false;
        if(user != null){
            user.setIsDisabled(isDisabled);
            flag = this.updateById(user);
        }
        return flag;
    }

}
