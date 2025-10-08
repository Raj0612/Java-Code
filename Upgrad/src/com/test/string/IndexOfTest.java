package com.test.string;

public class IndexOfTest {

    public static void main(String[] args) {
        String s1="this is index of example";
        String str1 = "geeks";
        String str2 = "geeksforgeeks";

        System.out.println("Index " + str1.indexOf(str2)); //Returns the index of this substring
        System.out.println("Index " + str2.indexOf(str1));

        int index1=s1.indexOf("is");
        int index2=s1.indexOf("index");
        int index3=s1.indexOf("is",8);//returns the index of is substring after 4th index
        int index4=s1.indexOf('s');

        System.out.println( "s1: " + s1 + "- indexOf(\"is\"): " +index1 + " indexOf(\"index\"): " + index2 + " indexOf(\"is\",4): " + index3 + " s1.indexOf('s'): " + index4);

    }
}
