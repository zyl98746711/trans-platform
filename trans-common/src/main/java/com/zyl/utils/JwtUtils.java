package com.zyl.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.zyl.common.dto.merchants.TokenDTO;

import java.util.Calendar;

/**
 * jwt工具类
 *
 * @author zyl
 */
public class JwtUtils {

    public static TokenDTO generateToken(Integer merchantsId, String tokenSign, String refreshTokenSign) {
        JWTCreator.Builder builder = JWT.create()
                .withClaim("merchants_id", merchantsId);
        Calendar calendar = Calendar.getInstance();
        // 1小时 token失效期
        calendar.add(Calendar.HOUR, 1);
        String token = builder
                .withExpiresAt(calendar.getTime())
                .sign(Algorithm.HMAC256(tokenSign));
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        String refreshToken = builder
                .withExpiresAt(calendar.getTime())
                .sign(Algorithm.HMAC256(refreshTokenSign));
        TokenDTO tokenDTO = new TokenDTO();
        tokenDTO.setToken(token);
        tokenDTO.setRefreshToken(refreshToken);
        return tokenDTO;


    }

    public static boolean validate(String token, String sign) {
        JWT.require(Algorithm.HMAC256(sign)).build().verify(token);
        return Boolean.TRUE;
    }
}
