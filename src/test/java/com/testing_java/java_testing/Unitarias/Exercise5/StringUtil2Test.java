package com.testing_java.java_testing.Unitarias.Exercise5;

import com.testing_java.java_testing.Unitarias.Exercise5.StringUtil2;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class StringUtil2Test {
    @Test
    void stringIsNotEmptyTest() {
        StringUtil2 stringUtil2=new StringUtil2("Hola como estas");

        Assert.assertEquals(false, stringUtil2.isEmpty());
    }

    @Test
    void quoteIsEmptyTest(){
        StringUtil2 stringUtil2=new StringUtil2("");

        Assert.assertEquals(true, stringUtil2.isEmpty());
    }

    @Test
    void nullIsEmptyTest(){
        StringUtil2 stringUtil2=new StringUtil2(null);

        Assert.assertEquals(true, stringUtil2.isEmpty());
    }

    @Test
    void quoteWithSpaceIsEmptyTest(){
        StringUtil2 stringUtil2=new StringUtil2(" ");

        Assert.assertEquals(true, stringUtil2.isEmpty());
    }
}