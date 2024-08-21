package com.zyl.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 加盐密码类
 *
 * @author zyl
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaltPassword {
    /**
     * 盐
     */
    private String salt;
    /**
     * 包装后的密码
     */
    private String warpPassword;
    /**
     * 原始密码
     */
    private String password;
}
