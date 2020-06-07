package com.zhy.demo.entity.form;

import com.zhy.demo.entity.po.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserForm extends BaseForm<User> {

    private String phone;

    private String email;

    private String username;

    private String pwd;

    private String name;


}
