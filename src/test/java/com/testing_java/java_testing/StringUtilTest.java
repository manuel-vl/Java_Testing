package com.testing_java.java_testing;

import com.testing_java.java_testing.Exercise1.StringUtil;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StringUtilTest {

    @Test
    public void repeatStringOnce(){
        String result= StringUtil.repeat("hola", 3);
        Assert.assertEquals("holaholahola", result);
    }

    @Test
    public void repeatStringMultipleTimes(){
        String result=StringUtil.repeat("hola",1);
        Assert.assertEquals("hola", result);
    }

    @Test
    public void repeatStringZeroTimes(){
        String result=StringUtil.repeat("hola",0);
        Assert.assertEquals("", result);
    }

    @Test()
    public void repeatStringNegativeTimes(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            StringUtil.repeat("hola", -1);
        });
    }
}