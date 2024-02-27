package com.testing_java.java_testing.TDD.Ejercicio6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateUtilTest {
    private DateUtil dateUtil;

    @BeforeEach
    public void setUp(){
        this.dateUtil=new DateUtil();
    }

    @Test
    void isLeapYearWhenYearIsDivisibleBy400() {
        assertEquals(true, dateUtil.isLeapYear(1600));
        assertEquals(true, dateUtil.isLeapYear(2000));
        assertEquals(true, dateUtil.isLeapYear(2400));
    }

    @Test
    void isNotLeapYearWhenIsDivisibleBy100ButNotBy400(){
        assertEquals(false, dateUtil.isLeapYear(1700));
        assertEquals(false, dateUtil.isLeapYear(1800));
        assertEquals(false, dateUtil.isLeapYear(1900));
    }

    @Test
    void IsLeapYearWhenIsDivisibleBy4ButNotBy100(){
        assertEquals(true, dateUtil.isLeapYear(1996));
        assertEquals(true, dateUtil.isLeapYear(2004));
        assertEquals(true, dateUtil.isLeapYear(2008));
    }

    @Test
    void IsNotLeapYearWhenIsNotDivisibleBy4(){
        assertEquals(false, dateUtil.isLeapYear(2017));
        assertEquals(false, dateUtil.isLeapYear(2019));
    }
}