package com.zhy.demo.entity.po;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * BasePo 基础po类
 *
 * @author zhy 2020-06-07
 */
@Data
public class BasePo implements Serializable {

    private static final long serialVersionUID = 1L;
    public final static String DEFAULT_USERNAME = "system";
    //主键id
    @TableId(type = IdType.AUTO)
    private Integer id;

    //创建操作人
    @TableField(fill = FieldFill.INSERT)
    private Integer createdBy;

    //插入时间
    @TableField(fill = FieldFill.INSERT)
    private Date insertTime;

    //更新操作人
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Integer updatedBy;

    //修改时间
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    //是否禁用
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Integer isDisabled;

    //是否删除
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Integer isDeleted;

    //版本
    @Version
    @TableField(fill = FieldFill.INSERT_UPDATE, update="%s+1")
    private Integer version;
}
