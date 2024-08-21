package com.zyl.common.web;

import lombok.Getter;
import lombok.Setter;

/**
 * web响应类
 *
 * @author zyl
 */
@Setter
@Getter
public class ResponseBody<T, P extends EmptyMeta> {

    private boolean success;

    private T body;

    private String message;

    /**
     * 成功响应
     *
     * @param t   数据
     * @param <T> 数据类型
     * @return 数据
     */
    public static <T> ResponseBody<T, EmptyMeta> success(T t) {
        ResponseBody<T, EmptyMeta> responseBody = new ResponseBody<>();
        responseBody.setBody(t);
        responseBody.setSuccess(Boolean.TRUE);
        responseBody.setMessage("success");
        return responseBody;
    }

    public static ResponseBody<Void, EmptyMeta> fail(String message) {
        ResponseBody<Void, EmptyMeta> responseBody = new ResponseBody<>();
        responseBody.setBody(null);
        responseBody.setSuccess(Boolean.FALSE);
        responseBody.setMessage(message);
        return responseBody;
    }
}
