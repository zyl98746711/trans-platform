package com.zyl.utils;

import com.zyl.common.SaltPassword;

import org.apache.commons.codec.binary.Hex;

import java.security.MessageDigest;
import java.util.Random;

/**
 * 编码相关工具类
 *
 * @author zyl
 */
public class CodeUtils {

    private static final Random random;
    private static final Hex hex;

    static {
        random = new Random();
        hex = new Hex();
    }

    public static SaltPassword generatePassword(String password) {
        String salt = generateSalt();
        String warpPassword = md5Hex(salt + password);
        return new SaltPassword(salt, warpPassword, password);
    }

    public static boolean validatePassword(String salt, String inputPassword, String password) {
        String warpPassword = md5Hex(salt + inputPassword);
        return password.equals(warpPassword);
    }


    private static String generateSalt() {
        return String.valueOf(random.nextInt(99999999) + (random.nextInt(99999999)));
    }


    private static String md5Hex(String src) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bs = md5.digest(src.getBytes());
            return new String(hex.encode(bs));
        } catch (Exception e) {
            return null;
        }
    }
    
}
