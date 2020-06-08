package com.zhy.demo.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *  角色实体
 * @author zhy 2020-06-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("cfg_role")
public class Role extends BasePo{

    /**
     * 角色code
     */
    private String code;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 简介
     */
    private String description;
}
