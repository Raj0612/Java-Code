package com.leetcode.stack;

import java.util.Stack;

public class RemoveAllAdjacentRemovalGroupsInAString {


   static  class Pair {
       char ch;
       int count;

       Pair(char ch, int count) {
           this.ch = ch;
           this.count = count;
       }
   }
    public static void main(String[] args) {

        String  input ="";
        input = "aabbba";
        input = "abxxxxxbbbx";
        System.out.println("removeAllAdjacentDuplicates " +  removeAllAdjacentDuplicates(input));
        System.out.println("removeGroupDuplicatesByStack " +  removeGroupDuplicatesByStack(input));
    }


    public static String removeGroupDuplicatesByStack(String s) {
        Stack<Pair> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek().ch == ch) {
                stack.peek().count++;
            } else {
                stack.push(new Pair(ch, 1));
            }

            // If group size > 1, remove entire group
            if (stack.peek().count > 1) {
                stack.pop();
            }
        }

        // Build result
        StringBuilder sb = new StringBuilder();
        for (Pair p : stack) {
            sb.append(p.ch);
        }

        return sb.toString();
    }

    public static String removeAllAdjacentDuplicates(String s) {
        boolean changed = true;

        while (changed) {
            changed = false;
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < s.length(); ) {
                int j = i;
                while (j < s.length() && s.charAt(i) == s.charAt(j)) {
                    j++;
                }

                if (j - i == 1) {
                    sb.append(s.charAt(i));
                } else {
                    changed = true;
                }

                i = j;
            }
            s = sb.toString();
        }
        return s;
    }
}


