package com.zhy.demo.config.service;

import com.google.common.collect.Lists;
import com.zhy.demo.entity.po.Permission;
import com.zhy.demo.entity.po.User;
import com.zhy.demo.service.IPermissionService;
import com.zhy.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    IUserService userService;

    @Autowired
    IPermissionService permissionService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getUserByUserName(username);
        List<GrantedAuthority> grantedAuthorities = Lists.newArrayList();
        if(user != null){
            List<Permission> permissions = permissionService.selectByUserId(user.getId());
            permissions.forEach(permission -> {
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission.getEname());
                grantedAuthorities.add(grantedAuthority);
            });
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPwd(),grantedAuthorities);
    }
}
