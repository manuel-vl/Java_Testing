package com.testing_java.java_testing.Unitarias_Mock.Exercise3;

public class Player {
    private Integer minNumberToWin;
    private Dado dado;

    public Player(Integer minNumberToWin, Dado dado) {
        this.minNumberToWin = minNumberToWin;
        this.dado = dado;
    }

    public boolean play(){
        Integer number=dado.roll();
        return number>=minNumberToWin;
    }
}
