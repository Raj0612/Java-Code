package com.leetcode.recursion;

import java.util.*;

public class LetterCombinationsOfAPhoneNumber {


    private static final String[] digitToLetters = {"",    "",    "abc",  "def", "ghi",
            "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static void main(String[] args) {

        String digits = "23";
      //  test(digits);
        //System.out.println("letterCombinations " + letterCombinations(digits));
       // System.out.println("letterCombinations1 " + letterCombinations1(digits));
        System.out.println("upgradeLetterCombinations " + upgradeLetterCombinations(digits));

    }

    public static List<String> letterCombinations(String digits) {
        HashMap<Character, char[]> dict = new HashMap<Character, char[]>();
        dict.put('2',new char[]{'a','b','c'});
        dict.put('3',new char[]{'d','e','f'});
        dict.put('4',new char[]{'g','h','i'});
        dict.put('5',new char[]{'j','k','l'});
        dict.put('6',new char[]{'m','n','o'});
        dict.put('7',new char[]{'p','q','r','s'});
        dict.put('8',new char[]{'t','u','v'});
        dict.put('9',new char[]{'w','x','y','z'});

        List<String> result = new ArrayList<String>();
        if(digits==null||digits.length()==0){
            return result;
        }

        char[] arr = new char[digits.length()];
        helper(digits, 0, dict, result, arr);

        return result;
    }


    private static void helper(String digits, int index, HashMap<Character, char[]> dict,
                               List<String> result, char[] arr){
        if(index==digits.length()){
            result.add(new String(arr));
            return;
        }

        char number = digits.charAt(index);
        char[] candidates = dict.get(number);
        System.out.println("number " + number + " candidates " + Arrays.toString(candidates));

        for(int i=0; i<candidates.length; i++){
            arr[index]=candidates[i];
            helper(digits, index+1, dict, result, arr);
        }
    }

    public static List<String> letterCombinations1(String digits) {
        if (digits.isEmpty())
            return new ArrayList<>();

        List<String> ans = new ArrayList<>();

        dfs(digits, 0, new StringBuilder(), ans);
        return ans;
    }

    private static void dfs(String digits, int i, StringBuilder sb, List<String> ans) {
        if (i == digits.length()) {
            ans.add(sb.toString());
            return;
        }

        for (final char c : digitToLetters[digits.charAt(i) - '0'].toCharArray()) {
            sb.append(c);
            dfs(digits, i + 1, sb, ans);
            sb.deleteCharAt(sb.length() - 1);
        }

    }

    static List<String> upgradeLetterCombinations(String digits){
        LinkedList<String> ans = new LinkedList<>();
        if(digits.isEmpty())
            return ans;
        String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        char[] arr = new char[digits.length()];
        upgradeHelper(0,digits.length(),digits,arr,mapping,ans);
        return ans;
    }
    static void upgradeHelper(int index, int digitsLen, String digits, char[] arr, String[] mapping, LinkedList<String> ans){

        if(index== digitsLen){
            String str = new String(arr);
            ans.add(str);
            return;
        }

        int digit = digits.charAt(index) - '0';
        String str = mapping[digit];
        for(char ch: str.toCharArray() ){
            arr[index] = ch;
            upgradeHelper(index+1, digitsLen, digits, arr, mapping, ans);
        }

    }


    static void test(String digits) {

        System.out.println("Digit " + digits.charAt(0));
        System.out.println("Array 0 " + Arrays.toString(digitToLetters[2].toCharArray()));
        System.out.println("Array 0 " + Arrays.toString(digitToLetters[digits.charAt(0) - '0'].toCharArray()));
        System.out.println("Array 1 " + Arrays.toString(digitToLetters[digits.charAt(1) - '0'].toCharArray()));

        // System.out.println("Array 1 " + Arrays.toString(digitToLetters[digits.charAt(1) -0].toCharArray()));
    }
}
