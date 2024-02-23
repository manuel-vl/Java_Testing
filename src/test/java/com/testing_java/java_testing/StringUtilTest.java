package com.testing_java.java_testing;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class StringUtilTest {

    @Test
    public void testRepear(){
        String result=StringUtil.repeat("hola", 3);
        Assert.assertEquals("holaholahola", result);

        String result2=StringUtil.repeat("hola",1);
        Assert.assertEquals("hola", result2);
    }
}