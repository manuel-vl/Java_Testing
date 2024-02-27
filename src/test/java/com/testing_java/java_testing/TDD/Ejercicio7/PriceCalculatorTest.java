package com.testing_java.java_testing.TDD.Ejercicio7;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PriceCalculatorTest {
    PriceCalculator priceCalculator;

    @BeforeEach
    public void setUp(){
        this.priceCalculator=new PriceCalculator();
    }

    @Test
    public void totalZeroWhenThereArePrices(){
        assertEquals(0.0, priceCalculator.getTotal());
    }

    @Test
    public void totalIsTheSumOfPrices(){
        priceCalculator.addPrice(10.2);
        priceCalculator.addPrice(15.5);

        assertEquals(25.7, priceCalculator.getTotal());
    }

    @Test
    public void applyDiscountToPrices(){
        priceCalculator.addPrice(12.5);
        priceCalculator.addPrice(17.5);

        priceCalculator.setDiscount(10d);

        assertEquals(27, priceCalculator.getTotal());
    }
}