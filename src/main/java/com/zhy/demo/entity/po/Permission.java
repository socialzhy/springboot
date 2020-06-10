package com.zhy.demo.entity.po;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 *  cfg_permission
 * @author zhy 2020-06-10
 */

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("cfg_permission")
public class Permission extends BasePo {


    private Integer parentId;

    private String name;

    private String ename;

    private String url;

    private String description;
}