package com.leetcode.backtracking;
//A parentheses string is a non-empty string consisting only of '(' and ')'. It is valid if any of the following conditions is true:
/*
It is ().
It can be written as AB (A concatenated with B), where A and B are valid parentheses strings.
It can be written as (A), where A is a valid parentheses string.
 */
//You are given a parentheses string s and a string locked, both of length n. locked is a binary string consisting only of '0's and '1's. For each index i of locked,
/*
If locked[i] is '1', you cannot change s[i].
But if locked[i] is '0', you can change s[i] to either '(' or ')'.
 */
//Return true if you can make s a valid parentheses string. Otherwise, return false.

/*
Example 1:
Input: s = "))()))", locked = "010100"
Output: true
Explanation: locked[1] == '1' and locked[3] == '1', so we cannot change s[1] or s[3].
We change s[0] and s[4] to '(' while leaving s[2] and s[5] unchanged to make s valid.

Example2:
Input: s = "()()", locked = "0000"
Output: true
Explanation: We do not need to make any changes because s is already valid.

Example 3:
Input: s = ")", locked = "0"
Output: false
Explanation: locked permits us to change s[0].
Changing s[0] to either '(' or ')' will not make s valid.

Example 4:
Input: s = "(((())(((())", locked = "111111010111"
Output: true
Explanation: locked permits us to change s[6] and s[8].
We change s[6] and s[8] to ')' to make s valid.
 */
public class CheckParenthesisStringIsValid {

    public static void main(String[] args) {
        input1();
        input2();
        input3();
    }

    static void input1(){
        String s = "))()))";
        String locked ="0000";
        System.out.println("input1: canBeValid " + canBeValid(s, locked));
    }

    static void input2(){
        String s = "(((())(((())";
        String locked = "111111010111";
        System.out.println("input2: canBeValid " + canBeValid(s, locked));
    }

    static void input3(){
        String s = "()()";
        String locked ="0000";
        System.out.println("input3: canBeValid " + canBeValid(s, locked));
    }

    public static boolean canBeValid(String s, String locked) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }
        int balance = 0;
        // Left-to-right scan to ensure all ')' can be matched
        for (int i = 0; i < n; ++i) {
            // If we have an unlocked character or a '(', we can potentially match a ')'
            if (s.charAt(i) == '(' || locked.charAt(i) == '0') {
                ++balance;
            } else if (balance > 0) {
                --balance;  // We have a locked ')' and we have an earlier '(', so pair them
            } else {
                return false; // Mismatched ')' which cannot be matched
            }
        }

        // Reset the balance counter for right-to-left scan
        balance = 0;

        // Right-to-left scan to ensure all '(' can be matched
        for (int i = n - 1; i >= 0; --i) {
            // If we have an unlocked character or a ')', we can potentially match a '('
            if (s.charAt(i) == ')' || locked.charAt(i) == '0') {
                ++balance;
            } else if (balance > 0) {
                --balance;  // We have a locked '(' and we have an earlier ')', so pair them
            } else {
                return false;  // Mismatched '(' which cannot be matched
            }
        }
        // If all the checks pass, the string can be made valid
        return true;
    }
}
