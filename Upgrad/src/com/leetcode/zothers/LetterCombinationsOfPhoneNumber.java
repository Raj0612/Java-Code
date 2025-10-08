package com.leetcode.zothers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfPhoneNumber {
    private static final Map<Character, char[]> KEYBOARD;
    static {
        KEYBOARD = new HashMap<>();
        KEYBOARD.put('2', "abc".toCharArray());
        KEYBOARD.put('3', "def".toCharArray());
        KEYBOARD.put('4', "ghi".toCharArray());
        KEYBOARD.put('5', "jkl".toCharArray());
        KEYBOARD.put('6', "mno".toCharArray());
        KEYBOARD.put('7', "pqrs".toCharArray());
        KEYBOARD.put('8', "tuv".toCharArray());
        KEYBOARD.put('9', "wxyz".toCharArray());
    }
    public static void main(String[] args) {
        String digits = "56";
        System.out.println("Result " + letterCombinationsOfPhoneNumber(digits));
    }

    public static List<String> letterCombinationsOfPhoneNumber(String digits) {
        List<String> res = new ArrayList<>();
        dfs(new StringBuilder(), res, digits.toCharArray());
        return res;
    }
    private static void dfs(StringBuilder path, List<String> res, char[] digits) {
        if (path.length() == digits.length) {
            res.add(path.toString());
            return;
        }
        char next_digit = digits[path.length()];
        for (char letter : KEYBOARD.get(next_digit)) {
            path.append(letter);
            dfs(path, res, digits);
            path.deleteCharAt(path.length() - 1);
        }
    }

}
