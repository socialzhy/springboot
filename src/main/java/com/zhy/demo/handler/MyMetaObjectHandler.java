package com.zhy.demo.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.zhy.demo.Util.UserContextHolder;
import com.zhy.demo.entity.po.BasePo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.Date;

@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    private static final String FIELD_INSERT_DATETIME = "insertTime";
    private static final String FIELD_CREATED_BY = "createdBy";
    private static final String FIELD_UPDATE_DATETIME = "updateTime";
    private static final String FIELD_UPDATED_BY = "updatedBy";
    private static final String FIELD_is_DISABLED = "isDisabled";
    private static final String FIELD_is_DELETED = "isDeleted";
    private static final String VERSION = "version";

    @Override
    public void insertFill(MetaObject metaObject) {
        Date now = Date.from(ZonedDateTime.now().toInstant());
        log.debug("start insert fill userId:{}", getUserId());
        this.setFieldValByName(FIELD_INSERT_DATETIME, now, metaObject);
        this.setFieldValByName(FIELD_CREATED_BY, getUserId(), metaObject);
        this.setFieldValByName(FIELD_UPDATE_DATETIME, now, metaObject);
        this.setFieldValByName(FIELD_UPDATED_BY, getUserId(), metaObject);
        this.setFieldValByName(FIELD_is_DISABLED, 0, metaObject);
        this.setFieldValByName(FIELD_is_DELETED, 0, metaObject);
        this.setFieldValByName(VERSION, 0, metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName(FIELD_UPDATE_DATETIME, Date.from(ZonedDateTime.now().toInstant()), metaObject);
        this.setFieldValByName(FIELD_UPDATED_BY, getUserId(), metaObject);
    }

    /**
     * 获取当前操作的用户名
     *
     * @return 当前操作用户名，若为空置为system
     */
    private String getUsername() {
        return StringUtils.defaultIfBlank(UserContextHolder.getInstance().getUsername(), BasePo.DEFAULT_USERNAME);
    }

    private int getUserId() {
        return UserContextHolder.getInstance().getUserID();
    }
}
