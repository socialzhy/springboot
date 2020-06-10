package com.zhy.demo.rest;

import com.zhy.demo.entity.form.RoleForm;
import com.zhy.demo.entity.vo.Result;
import com.zhy.demo.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    @PostMapping
    public Result add(@RequestBody RoleForm form){
        return Result.success(roleService.add(form));
    }
}
