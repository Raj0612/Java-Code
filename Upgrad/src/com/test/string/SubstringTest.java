package com.test.string;

public class SubstringTest {

    public static void main(String[] args) {
        String str = "test";

        for(int i =0 ; i<str.length()-1; i++){
            System.out.println("substring i " + i + ": " + str.substring(i+1));
        }

    }
}
