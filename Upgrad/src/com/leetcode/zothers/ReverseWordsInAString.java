package com.leetcode.zothers;
//Given an input string s, reverse the order of the words.
//A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
//Return a string of the words in reverse order concatenated by a single space.
//Note that s may contain leading or trailing spaces or multiple spaces between two words.
// The returned string should only have a single space separating the words. Do not include any extra spaces.


/*
Example1:
Input: s = "the sky is blue"
Output: "blue is sky the"

Input: s = "  hello world  "
Output: "world hello"
Explanation: Your reversed string should not contain leading or trailing spaces.

Input: s = "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
*/
public class ReverseWordsInAString {

    public static void main(String[] args) {
       // input1();
       input2();
       // input3();
    }

    public static String reverseWords(String s) {
        String[] parts = s.trim().split("\\s+");
        String out = "";
        for (int i = parts.length - 1; i > 0; i--) {
            out += parts[i] + " ";
        }
        return out + parts[0];
    }


    public static String reverseWords1(String s) {
        String [] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        int end = words.length - 1;
        for(int i = 0; i<= end; i++){
            if(!words[i].isEmpty()) {
                sb.insert(0, words[i]);
                System.out.println("reverseWords1 " + sb.toString());
                if(i < end) {
                    sb.insert(0, " ");
                }
            }
        }
        return sb.toString();
    }

    public static String reverseWordsTwoPointers(String s) {
        if (s == null) return null;

        char[] a = s.toCharArray();
        System.out.println("reverseWordsTwoPointers " + new String(a));
        int n = a.length;

        // step 1. reverse the whole string
        reverse(a, 0, n - 1);
        System.out.println("reverseWordsTwoPointers1 " + new String(a));
        // step 2. reverse each word
        reverseWords(a, n);
        System.out.println("reverseWordsTwoPointers2 " + new String(a));
        // step 3. clean up spaces
        return cleanSpaces(a, n);
    }

   static void reverseWords(char[] a, int n) {
        int i = 0, j = 0;

        while (i < n) {
            while (i < j || i < n && a[i] == ' ')
                i++; // skip spaces
            while (j < i || j < n && a[j] != ' ')
                j++; // skip non spaces
            reverse(a, i, j - 1);                      // reverse the word
        }
    }

    // trim leading, trailing and multiple spaces
    static String cleanSpaces(char[] a, int n) {
        int i = 0, j = 0;

        while (j < n) {
            while (j < n && a[j] == ' ')
                j++;             // skip spaces
            while (j < n && a[j] != ' ')
                a[i++] = a[j++]; // keep non spaces
            while (j < n && a[j] == ' ')
                j++;             // skip spaces
            if (j < n)
                a[i++] = ' ';    // keep only one space
        }

        return new String(a).substring(0, i);
    }

    // reverse a[] from a[i] to a[j]
    static void reverse(char[] a, int i, int j) {
        while (i < j) {
            char t = a[i];
            a[i++] = a[j];
            a[j--] = t;
        }
    }

    static void input1(){
        String s = "the sky is blue";
        System.out.println("input1 s: " + s);
        System.out.println("input1: " + reverseWords(s));
       // System.out.println("input1: " + reverseWords1(s));
       // System.out.println("input1: reverseWordsTwoPointers " + reverseWordsTwoPointers(s));
        System.out.println();
    }

    static void input2(){
        String s = "  hello world  ";
        System.out.println("input2 s: " + s);
       // System.out.println("input2: " + reverseWords(s));
    //    System.out.println("input2: " + reverseWords1(s));
         System.out.println("input2: reverseWordsTwoPointers " + reverseWordsTwoPointers(s));
        System.out.println();
    }

    static void input3(){
        String s = "a good   example";
        System.out.println("input3 s: " + s);
        //System.out.println("input3: " + reverseWords(s));
       // System.out.println("input3: " + reverseWords1(s));
     //   reverseAString(s);
        System.out.println("input3: reverseWordsTwoPointers " + reverseWordsTwoPointers(s));
    }

    static void reverseAString(String str){
        int length = str.length();
        String reversed = "";

        int i = length - 1;
        while (i >= 0) {
            reversed += str.charAt(i);
            i--;
        }
        System.out.println("Reversed " + reversed);
    }
}
