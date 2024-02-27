package com.testing_java.java_testing.TDD.Ejercicio7;

import java.util.ArrayList;
import java.util.List;

public class PriceCalculator {
    private Double discount=0d;

    private List<Double> prices=new ArrayList<>();

    public PriceCalculator() {
    }

    public Double getTotal(){
        Double result=0D;

        for(Double price: prices){
            result+=price;
        }

        return result*((100-discount)/100);
    }

    public void addPrice(double price) {
        prices.add(price);
    }

    public void setDiscount(Double discount) {
        this.discount=discount;
    }
}
