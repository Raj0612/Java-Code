package com.leetcode.stack;

import java.util.Stack;
//You are given a string s consisting of lowercase English letters. A duplicate removal consists of choosing two adjacent and equal letters and removing them.
//We repeatedly make duplicate removals on s until we no longer can.
//Return the final string after all such duplicate removals have been made. It can be proven that the answer is unique.
/*
Example 1:
Input: s = "abbaca"
Output: "ca"
Explanation:
For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".

Example 2:
Input: s = "azxxzy"
Output: "ay"
 */
public class RemoveAllAdjacentDuplicatesInAString {

    public static void main(String[] args) {
        String str = "";
        str = "abbaca";
        //str = "azxxzy";
       str = "aabbba";
      // str = "abbaca";
        System.out.println("input : " + str);
        System.out.println("removeDuplicates " + removeDuplicates(str));
        System.out.println("removeDuplicatesByBruteForce " + removeDuplicatesByBruteForce(str));
        System.out.println("removeAdjacentDuplicates " + removeAdjacentDuplicates(str));
        removeDuplicates1(str);
      //  System.out.println("removeDuplicatesNotOptimized " + removeDuplicatesNotOptimized(str));
    }


    public static void removeDuplicates1(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!stack.isEmpty()) {
                while (!stack.isEmpty() &&stack.peek() == ch) {
                    stack.pop();
                }
            } else{
                    stack.add(ch);
                }
            }
            System.out.println("removeDuplicates1 stack " + stack);
        }

    public static String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(!stack.isEmpty() && stack.peek()==ch){
                stack.pop();
            } else{
                stack.add(ch);
            }
        }
        System.out.println("removeDuplicates stack " + stack);
        StringBuilder sb = new StringBuilder("");
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        String x = String.valueOf(sb);
        x = reverse(x);
        return x;
    }
    public static String reverse(String s){
        char[] charArray = s.toCharArray();
        int left = 0;
        int right = charArray.length-1;
        while(left<right){
            char ch = charArray[right];
            charArray[right] = charArray[left];
            charArray[left] = ch;
            left++;
            right--;
        }
        return new String(charArray);
    }

    public static String removeDuplicatesByBruteForce(String s) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < sb.length(); i++) {
            if (i + 1 < sb.length() && sb.charAt(i) == sb.charAt(i + 1)) {
                sb.delete(i, i + 2);
                i = -1;
            }
        }
        return sb.toString();
    }

    public static String removeDuplicatesNotOptimized(String s) {
        boolean has_Duplicate = false;
        StringBuilder sb = new StringBuilder(s); //Space - O(n)

        while(true){ // (n/2 times at max)
            for(int i=0; i< sb.length();i++){ // O(n)
                has_Duplicate = false;
                if(s.charAt(i) == sb.charAt(i+1)) {
                    sb.delete(i, i + 2);
                    has_Duplicate = true;
                    break;
                }
            }

            if(!has_Duplicate)
                break;
        }
        return sb.toString();
    }

    public static String removeAdjacentDuplicates(String s) {
        if (s == null || s.length() == 0) return s;

        StringBuilder result = new StringBuilder();
        result.append(s.charAt(0)); // first char always included

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                result.append(s.charAt(i));
            }
        }

        return result.toString();
    }
}
