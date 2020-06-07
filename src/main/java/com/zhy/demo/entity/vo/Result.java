package com.zhy.demo.entity.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.time.Instant;
import java.time.ZonedDateTime;

/**
 *  接口统一返回类
 * @author zhy 2020-06-07
 */
@Getter
public class Result<T> {

    public static final String SUCCESSFUL_CODE = "000000";
    public static final String SUCCESSFUL_MESG = "处理成功";

    private String code;
    private String mesg;
    private Instant time;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    /**
     * 内部使用，用于构造成功的结果
     *
     * @param code
     * @param mesg
     * @param data
     */
    private Result(String code, String mesg, T data) {
        this.code = code;
        this.mesg = mesg;
        this.data = data;
        this.time = ZonedDateTime.now().toInstant();
    }

    public Result() {
        this.time = ZonedDateTime.now().toInstant();
    }

    public static Result success(Object data) {
        return new Result<>(SUCCESSFUL_CODE, SUCCESSFUL_MESG, data);
    }
}
