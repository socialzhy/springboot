package com.zhy.demo.rest;

import com.zhy.demo.entity.form.UserForm;
import com.zhy.demo.entity.vo.Result;
import com.zhy.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class TestController {

    @Autowired
    private IUserService userService;

    @GetMapping("/{userId}")
    public Result test(@PathVariable String userId){
        return Result.success(userService.getByUserId(Integer.parseInt(userId)));
    }

    @PostMapping
    public Result add(@RequestBody UserForm userForm){
        return Result.success(userService.add(userForm));
    }

    @PutMapping(value = "/{userId}/{isDisabled}")
    public Result update(@PathVariable Integer userId, @PathVariable Integer isDisabled){
        return Result.success(userService.updateDisable(userId,isDisabled));
    }
}
