package com.testing_java.java_testing;

import java.util.Random;

public class Dado {
    private Integer caras;

    public Dado(Integer caras) {
        this.caras = caras;
    }

    public Integer roll(){
        return new Random().nextInt(caras)+1;
    }
}
