package com.zhy.demo.rest;

import com.google.common.collect.Maps;
import com.zhy.demo.entity.form.UserForm;
import com.zhy.demo.entity.vo.Result;
import com.zhy.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/{userId}")
    public Result test(@PathVariable String userId){
        String userName = this.getUserName();
        System.out.println(userName);
        return Result.success(userService.getByUserId(Integer.parseInt(userId)));
    }

    @PostMapping
    public Result add(@RequestBody UserForm form){
        return Result.success(userService.add(form));
    }

    @PutMapping(value = "/{userId}/{isDisabled}")
    @PreAuthorize("System")
    public Result update(@PathVariable Integer userId, @PathVariable Integer isDisabled){
        return Result.success(userService.updateDisable(userId,isDisabled));
    }

    @PostMapping("/loginSuccess")
    public Result success(){
        return Result.success("xxxx");
    }


    private String getUserName(){
        String username;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        if(principal == null){
            username = "匿名";
        }
        if(principal instanceof UserDetails){
            username = ((UserDetails) principal).getUsername();
        }else {
            username = principal.toString();
        }

        return username;
    }
}
