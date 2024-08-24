package com.zyl.common.web;

import lombok.Data;

/**
 * @author zyl
 */
@Data
public class HttpResponse<R> {

    private String message;

    private boolean success;

    private R response;
}
