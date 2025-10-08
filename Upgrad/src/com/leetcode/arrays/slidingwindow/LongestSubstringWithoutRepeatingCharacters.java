package com.leetcode.arrays.slidingwindow;
//Given a string s, find the length of the longest  substring without repeating characters.

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*Example1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example2:
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
       // input1();
       //input2();
        input3();
    }
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        int start = 0;
        int end = 0;
        int maxLength = 0;
        Set<Character> uniqueCharacters = new HashSet<>();
        while (end < s.length()) {
            if (uniqueCharacters.add(s.charAt(end))) {
                end++;
                maxLength = Math.max(maxLength, uniqueCharacters.size());
            } else {
                uniqueCharacters.remove(s.charAt(start));
                start++;
            }
        }
        return maxLength;
    }


    public static int lengthOfLongestSubstring1(String s) {
        Set<Character> ss = new HashSet<>();
        int i = 0, ans = 0;
        for (int j = 0; j < s.length(); ++j) {
            char c = s.charAt(j);
            while (ss.contains(c)) {
                ss.remove(s.charAt(i++));
            }
            ss.add(c);
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }

    public static int lengthOfLongestSubstring2(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        int i = 0;
        for (int j = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
               i = Math.max(map.get(s.charAt(j)) + 1, i);
           //     i = map.get(s.charAt(j)) + 1;
            }
            map.put(s.charAt(j), j);
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }

    public static int lengthOfLongestSubstringByBruteForce(String s) {
        int n = s.length();

        int ans = 0;
        for (int i = 0; i < n; i++) { // O(n)
            for (int j = i; j < n; j++) { // O(n)
                if (!checkRepetition(s, i, j)) { // O(n)
                    break;
                }else{
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }

        return ans;
    }

    static boolean checkRepetition(String s, int start, int end) { // O(n)
        Set<Character> chars = new HashSet<>();

        for (int i = start; i <= end; i++) {
            char c = s.charAt(i);
            if(chars.contains(c)){
                return false;
            }
            chars.add(c);
        }

        return true;
    }
    static void input1(){
        String str = "abcabca";
        System.out.println("input1 lengthOfLongestSubstringByBruteForce " + lengthOfLongestSubstringByBruteForce(str));
        System.out.println("input1 lengthOfLongestSubstring2 " + lengthOfLongestSubstring2(str));
    }


    static void input2(){
        String str = "pwwwkew";
       // System.out.println("input2 lengthOfLongestSubstringByBruteForce " + lengthOfLongestSubstringByBruteForce(str));
        System.out.println("input2 lengthOfLongestSubstring1 " + lengthOfLongestSubstring1(str));
        System.out.println("input2 lengthOfLongestSubstring2 " + lengthOfLongestSubstring2(str));
    }

    static void input3(){
        String str = "abcabcda";
        str = "abcbbdace";
        str = "abcbde";
       // System.out.println("input3 lengthOfLongestSubstringByBruteForce " + lengthOfLongestSubstringByBruteForce(str));
        System.out.println("input3 lengthOfLongestSubstring1 " + lengthOfLongestSubstring1(str));
        System.out.println("input3 lengthOfLongestSubstring2 " + lengthOfLongestSubstring2(str));
    }
}
