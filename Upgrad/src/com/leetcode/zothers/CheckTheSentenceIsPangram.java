package com.leetcode.zothers;

//A pangram is a sentence where every letter of the English alphabet appears at least once.
//Given a string sentence containing only lowercase English letters, return true if sentence is a pangram, or false otherwise.

import java.util.HashSet;
import java.util.Set;

/*Example 1:
        Input: sentence = "thequickbrownfoxjumpsoverthelazydog"
        Output: true
        Explanation: sentence contains at least one of every letter of the English alphabet.

Example 2:
        Input: sentence = "leetcode"
        Output: false*/
public class CheckTheSentenceIsPangram {

    public static void main(String[] args) {
        input1();
        input2();
    }

/*  Time : O(n)
    Space : O(26) == O(1)    */
    static boolean isPangram(String sentence){
        Set<Character> seen = new HashSet<>();
        for (final char c : sentence.toCharArray())
            seen.add(c);
        return seen.size() == 26;
    }

    static boolean isPangramByArray(String sentence){

        int arr[] = new int[26];
        for(int i=0; i< sentence.length(); i++){
            arr[sentence.charAt(i)-'a']++;
        }

        for(int i =0; i< 26; i++){
            if(arr[i]==0){
                return false;
            }
        }
        return true;
    }
    static void input1(){
        String str = "thequickbrownfoxjumpsoverthelazydog";
        System.out.println("input1 " + isPangram(str));
    }

    static void input2(){
        String str = "leetcode";
        System.out.println("input2 " + isPangram(str));
    }
}
