package com.testing_java.java_testing.TDD.Ejercicio8;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTest {
    // Usando TDD (empieza por los tests), implementa una función que dado un número:
    // Si el número es divisible por 3, retorna “Fizz”
    // Si el número es divisible por 5, retorna “Buzz”
    // Si el número es divisible por 3 y por 5, retorna “FizzBuzz”
    // En otro caso, retorna el mismo número
    FizzBuzz fizzBuzz;

    @BeforeEach
    void setUp(){
        this.fizzBuzz=new FizzBuzz();
    }

    @Test
    void numberDivisibleBy3(){
        assertEquals("Fizz", fizzBuzz.fizzbuzz(3));
        assertEquals("Fizz", fizzBuzz.fizzbuzz(6));
        assertEquals("Fizz", fizzBuzz.fizzbuzz(9));
    }

    @Test
    void numberDivisibleBy5(){
        assertEquals("Buzz", fizzBuzz.fizzbuzz(5));
        assertEquals("Buzz", fizzBuzz.fizzbuzz(10));
        assertEquals("Buzz", fizzBuzz.fizzbuzz(20));
    }

    @Test
    void numberDivisibleBy5And3(){
        assertEquals("FizzBuzz", fizzBuzz.fizzbuzz(15));
        assertEquals("FizzBuzz", fizzBuzz.fizzbuzz(30));
        assertEquals("FizzBuzz", fizzBuzz.fizzbuzz(45));
    }

    @Test
    void numberNotDivisibleBy3or5(){
        assertEquals("1", fizzBuzz.fizzbuzz(1));
        assertEquals("4", fizzBuzz.fizzbuzz(4));
        assertEquals("7", fizzBuzz.fizzbuzz(7));
    }

}