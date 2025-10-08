package com.leetcode.recursion;

public class ReverseAString {

    public static void main(String[] args) {
        String sentence = "Go work";
        String reversed = reverse(sentence);
        System.out.println("The reversed sentence is: " + reversed);
    }

    public static String reverse(String sentence) {
        if (sentence.isEmpty())
            return sentence;
        else {
            System.out.println("sentence.substring(1) " + sentence.substring(1) + " sentence.charAt(0) " + sentence.charAt(0));
            //System.out.println((sentence.substring(1)));
            System.out.println((sentence.substring(1)) + sentence.charAt(0));
        }

        return reverse(sentence.substring(1)) + sentence.charAt(0);
    }
}
