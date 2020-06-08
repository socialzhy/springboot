package com.zhy.demo.entity.form;

import com.zhy.demo.entity.po.Role;
import lombok.Data;

@Data
public class RoleForm extends BaseForm<Role>{

    private String code;

    private String name;

    private String description;
}
