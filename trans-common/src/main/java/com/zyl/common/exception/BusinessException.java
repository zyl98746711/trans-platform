package com.zyl.common.exception;

/**
 * 业务异常
 *
 * @author zyl
 */
public class BusinessException extends RuntimeException {
    
    public BusinessException(String message) {
        super(message);
    }
}
