package com.testing_java.java_testing.Exercise2;

import com.testing_java.java_testing.Exercise2.PasswordUtil;
import org.junit.Assert;
import org.junit.jupiter.api.Test;


class PasswordUtilTest {
    @Test
    public void weakWhenHasLessThan8Letters() {
        Assert.assertEquals(PasswordUtil.SecurityLevel.WEAK,PasswordUtil.assessPassword("1234567"));
    }

    @Test
    public void weakWhenHassOnlyLetters(){
        Assert.assertEquals(PasswordUtil.SecurityLevel.WEAK, PasswordUtil.assessPassword("abcdefg"));
    }

    @Test
    public void mediumWhenHasLettersAndNumbers(){
        Assert.assertEquals(PasswordUtil.SecurityLevel.MEDIUM, PasswordUtil.assessPassword("abcd12345"));
    }

    @Test
    public void strongWhenHasLettersNumbersAndSymbols() {
        Assert.assertEquals(PasswordUtil.SecurityLevel.STRONG, PasswordUtil.assessPassword("abcd123!"));
    }
}