package com.zyl.utils;

import com.zyl.common.SaltPassword;

import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * @author zyl
 */
public class CodeUtilsTests extends TestCase {


    public void testValidatePassword() {
        String password = "123456";
        SaltPassword saltPassword = CodeUtils.generatePassword(password);
        String salt = saltPassword.getSalt();
        boolean success = CodeUtils.validatePassword(salt, password, saltPassword.getWarpPassword());
        Assert.assertTrue(success);
    }
}
