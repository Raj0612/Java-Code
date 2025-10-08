package com.leetcode.recursion;

import java.util.ArrayList;
import java.util.List;
//Given a string s, you can transform every letter individually to be lowercase or uppercase to create another string.
//Return a list of all possible strings we could create. Return the output in any order.

/*
Example 1:
Input: s = "a1b2"
Output: ["a1b2","a1B2","A1b2","A1B2"]

Example 2:
Input: s = "3z4"
Output: ["3z4","3Z4"]
 */
public class LetterCasePermutation {

    public static void main(String[] args) {
        String letters = "a1b2";
        upgradLetterCasePermutation(letters);
    }

    static void upgradLetterCasePermutation(String letters){
        List<String> result = new ArrayList<>();
        char[] arr = new char[letters.length()];
        upgradHelper(0,letters, letters.length(), arr, result);
        System.out.println("upgradLetterCasePermutation result " + result);
    }

    static void upgradHelper(int index, String letters, int lettersLen , char[] arr ,List<String> result){

        if(index == lettersLen){
            String str = new String(arr);
            result.add(str);
            return;
        }

//        if(Character.isDigit(letters.charAt(index))){
//            arr[index] = letters.charAt(index);
//            upgradHelper(index+1, letters, lettersLen, arr, result);
//        }else {
//            arr[index] = Character.toLowerCase(letters.charAt(index));
//            upgradHelper(index+1, letters, lettersLen, arr, result);
//            arr[index] = Character.toUpperCase(letters.charAt(index));
//            upgradHelper(index+1, letters, lettersLen, arr, result);
//        }

        if(!Character.isDigit(letters.charAt(index))){
            arr[index] = Character.toLowerCase(letters.charAt(index));
            upgradHelper(index+1, letters, lettersLen, arr, result);
            arr[index] = Character.toUpperCase(letters.charAt(index));
            upgradHelper(index+1, letters, lettersLen, arr, result);
        }else {
            arr[index] = letters.charAt(index);
            upgradHelper(index+1, letters, lettersLen, arr, result);
        }

    }
}
