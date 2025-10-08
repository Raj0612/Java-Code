package com.leetcode.queue;


import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.Deque;
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
        String str = "azxxzy";
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
    public static String removeDuplicates1(String s, int k) {
        Deque<int[]> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); ++i) {
            int index = s.charAt(i) - 'a';
            if (!stack.isEmpty() && stack.peek()[0] == index) {
                stack.peek()[1] = (stack.peek()[1] + 1) % k;
                if (stack.peek()[1] == 0) {
                    stack.pop();
                }
            }else {
                stack.push(new int[] {index, 1});
            }
        }

        StringBuilder result = new StringBuilder();
        for (int[] element : stack) {
            char c = (char) (element[0] + 'a');
            for (int i = 0; i < element[1]; ++i) {
                result.append(c);
            }
        }
        result.reverse();
        return result.toString();
    }
}
