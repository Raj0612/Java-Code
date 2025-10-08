package com.leetcode.zothers;
//Given an input string, reverse the string word by word.

//A word is defined as a sequence of non-space characters.
//The input string does not contain leading or trailing spaces.
//The words are always separated by a single space

import java.util.Arrays;

/*
Example1:
Input:
["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]

Output:
["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]*/
public class ReverseWordsInAStringII {

    public static void main(String[] args) {
        input1();
    }
    public static void reverse(char[] s, int left, int right) {
        while (left < right) {
            char tmp = s[left];
            s[left++] = s[right];
            s[right--] = tmp;
        }
    }

    public static void reverseEachWord(char[] s) {
        int n = s.length;
        int start = 0, end = 0;

        while (start < n) {
            // go to the end of the word
            while (end < n && s[end] != ' '){
               // ++end;
                end ++;
            }

            // reverse the word
            reverse(s, start, end - 1);
            // move to the next word
            start = end + 1;
            ++end;
        }
    }

    public static void reverseWords(char[] s) {
        // reverse the whole string
        reverse(s, 0, s.length - 1);
        System.out.println("reverseWords1 " + Arrays.toString(s));

        // reverse each word
        reverseEachWord(s);
    }
    static void input1(){

        char[] c ={'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'};

        reverseWords(c);
        System.out.println("input1: " + Arrays.toString(c));
        System.out.println("input1: " + new String(c));
    }

}
