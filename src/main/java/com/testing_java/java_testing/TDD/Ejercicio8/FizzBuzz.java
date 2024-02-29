package com.testing_java.java_testing.TDD.Ejercicio8;

public class FizzBuzz {
    public FizzBuzz(){
    }

    public String fizzbuzz(Integer num){
        if (num % 3 == 0 && num % 5 == 0) return"FizzBuzz";
        if (num % 3 == 0) return"Fizz";
        if (num % 5 == 0) return"Buzz";

        return ""+num;
    }


}
