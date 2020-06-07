package com.zhy.demo.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *  用户类实体
 * @author zhy 2020-06-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("cfg_user")
public class User extends BasePo {

    /**
     * 手机号
     */
    private String phone;

    /**
     * 用户名
     */
    private String username;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 密码
     */
    private String pwd;

    /**
     * 姓名
     */
    private String name;

}
