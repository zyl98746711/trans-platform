package com.zyl.common.dto.merchants;

import lombok.Data;

/**
 * 保存商家DTO
 *
 * @author zyl
 */
@Data
public class MerchantsSaveDTO {

    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String password;
}
