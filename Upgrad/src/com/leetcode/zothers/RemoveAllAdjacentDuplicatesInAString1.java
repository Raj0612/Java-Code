package com.leetcode.zothers;

/*
    Input: s = "abbaca"
        Output: "abaca"
 */
public class RemoveAllAdjacentDuplicatesInAString1 {
    public static void main(String[] args) {
        input1();
        input2();
    }
    public static String removeDuplicates(final String string) {
        System.out.println("removeDuplicates " + string);
        if (string == null) {
            return null;
        }
        char[] chars = string.toCharArray();
        char previous = ' ';
        int i = 0;
        for (char c : chars) {
            if (c != previous) {
                chars[i++] = c;
                previous = c;
            }
        }
        return new String(chars).substring(0, i);

    }
    static void input1(){
        String str = "abbaca";
        System.out.println("input1 removeDuplicates " + removeDuplicates(str));
    }

    static void input2(){
        String str = "azxxxzy";
        System.out.println("input2 removeDuplicates " + removeDuplicates(str));
    }
}
