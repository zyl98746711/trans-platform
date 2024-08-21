package com.zyl.common.dto.merchants;

import lombok.Getter;
import lombok.Setter;

/**
 * tokenDto
 *
 * @author zyl
 */
@Getter
@Setter
public class TokenDTO {

    /**
     * token
     */
    private String token;
    /**
     * refresh token
     */
    private String refreshToken;
}
