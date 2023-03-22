package com.zj.common;

import lombok.Getter;

/**
 * @Author zj
 * @Date 2022/8/6 10:43
 * @PackageName:com.qf.room.core.utils
 * @ClassName: Codes
 * @Description:
 * @Version 1.0
 */
@Getter
public enum Codes {
    SUCCESS(200,"成功！"),
    FAIL(500,"错误"),
    DATA_CHECK_ERROR(401, "参数校验异常！"),
    FLOW_ERROR(402,"限流异常！"),
    DEGRADE_ERROR(403, "熔断异常！"),
    DATA_UNIQUE_ERROR(405,"添加数据异常！"),
    AUTH_FAIL(406, "没有登录，不能访问该资源！"),
    NO_POWER_ERROR(407, "权限不足！"),
    TOKEN_GET_ERROR(408, "令牌获取错误！"),
    LOGIN_ERROR(409, "登录失败！"),
    RED_TIMEOUT(410, "红包已经过期"),
    RED_OVER(411, "红包已经抢完"),
    RED_EXISTS(412, "红包已经抢过");

    private Integer code;
    private String msg;

    Codes(Integer code,String msg) {
        this.code = code;
        this.msg = msg;
    }
}
