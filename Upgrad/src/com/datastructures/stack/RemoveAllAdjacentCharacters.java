package com.datastructures.stack;

import java.util.Stack;

public class RemoveAllAdjacentCharacters {

    public static void main(String[] args) {
        String s = "";
        s = "azxxzy";
        s = "abxxxxxbbbx";
        System.out.println("removeAllAdjacent " + removeAllAdjacent(s));
    }


    public static String removeAllAdjacent(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == ch) {
                // Remove all adjacent duplicates
                while (!stack.isEmpty() && stack.peek() == ch) {
                    stack.pop();
                }
            } else {
                stack.push(ch);
            }
        }

        // Build result
        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }
}
