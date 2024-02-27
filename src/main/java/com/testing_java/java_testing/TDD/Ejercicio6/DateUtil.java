package com.testing_java.java_testing.TDD.Ejercicio6;

public class DateUtil {
    public DateUtil() {
    }

    public Boolean isLeapYear(Integer year){
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }
}
