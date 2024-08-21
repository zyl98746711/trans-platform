package com.zyl.common.dto.merchants;

import lombok.Getter;
import lombok.Setter;

/**
 * 商家DTO
 *
 * @author zyl
 */
@Getter
@Setter
public class MerchantsLoginDTO {

    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String password;
}
