package com.leetcode.stack;

import java.util.Stack;
//You are given a string s and an integer k, a k duplicate removal consists of choosing k adjacent and equal letters from s and removing them,
// causing the left and the right side of the deleted substring to concatenate together.
//We repeatedly make k duplicate removals on s until we no longer can.
//Return the final string after all such duplicate removals have been made. It can be proven that the answer is unique.
/*
Example 1:
Input: s = "abcd", k = 2
Output: "abcd"
Explanation: There's nothing to delete.

Example 2:
Input: s = "deeedbbcccbdaa", k = 3
Output: "aa"
Explanation:
First delete "eee" and "ccc", get "ddbbbdaa"
Then delete "bbb", get "dddaa"
Finally delete "ddd", get "aa"

Example 3:
Input: s = "pbbcggttciiippooaais", k = 2
Output: "ps"
 */
public class RemoveAllAdjacentDuplicatesInAStringII {
    public static void main(String[] args) {
        input1();
        input2();
    }

    static void input1(){
        String str = "azxxxzy";
        int k = 2;
        System.out.println("input1 str: " + str);
        System.out.println("input1 removeDuplicates " + removeDuplicates(str, k));
    }

    static void input2(){
        String str = "deeedbbcccbdaa";
        int k = 3;
        System.out.println("input2 str: " + str);
        System.out.println("input2 removeDuplicates " + removeDuplicates(str, k));
    }

    public static String removeDuplicates(String s, int k) {
        Stack<Pair> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek().character == c) {
                stack.peek().count++;
                if (stack.peek().count == k) {
                    stack.pop();
                }
            } else {
                stack.push(new Pair(c, 1));
            }
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            Pair p = stack.pop();
            for (int i = 0; i < p.count; i++) {
                result.append(p.character);
            }
        }

        return result.reverse().toString();
    }

    static  class Pair {
        char character;
        int count;

        public Pair(char character, int count) {
            this.character = character;
            this.count = count;
        }
    }

    public static String removeDuplicates1(String S, int K) {
        char[] SC = S.toCharArray();
        int i, j;
        Stack<Integer> st = new Stack<>();
        st.add(0);
        for (i = 1, j = 1; j < S.length(); i++, j++) {
            char chr = SC[i] = SC[j];
            if (i == 0 || chr != SC[i-1]) {
                st.add(i);
            }
            else if (i - st.peek() + 1 == K) {
                i = st.pop() - 1;
            }
        }
        return new String(SC, 0, i);
    }
}
