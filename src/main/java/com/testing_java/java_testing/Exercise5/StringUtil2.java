package com.testing_java.java_testing.Exercise5;

public class StringUtil2 {
    private String text;

    public StringUtil2(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean isEmpty(){
        return text==null || text.trim().length() == 0;
    }
}
