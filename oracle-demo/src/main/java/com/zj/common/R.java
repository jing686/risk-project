package com.zj.common;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @Author zj
 * @Date 2022/8/6 10:42
 * @PackageName:com.qf.room.core.utils
 * @ClassName: R
 * @Description:
 * @Version 1.0
 */
@Data
@Accessors(chain = true)
@ToString(callSuper = true)
public class R<T> {
    private Integer code;
    private String msg;
    private T data;

    /**
     * 默认成功
     * @param <S>
     * @return
     */
    public static <S> R<S> createSuccess() {
        return new R()
                .setCode(Codes.SUCCESS.getCode())
                .setMsg(Codes.SUCCESS.getMsg());
    }

    /**
     * 返回成功 携带成功的数据
     * @param data
     * @return
     * @param <S>
     */
    public static <S> R<S> createSuccess(S data) {
        return new R().setCode(Codes.SUCCESS.getCode())
                .setMsg(Codes.SUCCESS.getMsg())
                .setData(data);
    }

    /**
     * 默认失败
     * @return
     * @param <S>
     */
    public static <S> R<S> createFail(){
        return new R().setCode(Codes.FAIL.getCode())
                .setMsg(Codes.FAIL.getMsg());
    }
    /**
     * 返回失败数据
     * @param code
     * @return
     * @param <S>
     */
    public static <S> R<S> createFail(Codes code){
        return new R().setCode(code.getCode())
                .setMsg(code.getMsg());
    }

    /**
     * 返回自定义失败提示
     * @param code
     * @param msg
     * @return
     * @param <S>
     */
    public static <S> R<S> createFail(Codes code,String msg){
        return new R().setCode(code.getCode())
                .setMsg(msg);
    }

    /**
     * 返回自定义失败数据
     * @param code
     * @param data
     * @return
     * @param <S>
     */
    public static <S> R<S> createFail(Codes code,S data){
        return new R().setCode(code.getCode())
                .setMsg(code.getMsg())
                .setData(data);
    }

    /**
     * 自定义失败
     * @param code
     * @param msg
     * @return
     * @param <S>
     */
    public static <S> R<S> createFail(Integer code,String msg){
        return new R().setCode(code)
                .setMsg(msg);
    }
}
