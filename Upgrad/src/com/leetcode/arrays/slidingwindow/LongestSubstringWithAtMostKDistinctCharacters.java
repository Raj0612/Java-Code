package com.leetcode.arrays.slidingwindow;

//You are given a string "str" and an integer K. You have to find the length of the largest substring with at most K distinct characters

import java.util.HashMap;
import java.util.Map;

/*Example 1:
Input: s = "eceba", k = 2
Output: 3
Explanation: T is "ece" which its length is 3.

Example2:
Input: s = "aa", k = 1
Output: 2
Explanation: T is "aa" which its length is 2.

 */
public class LongestSubstringWithAtMostKDistinctCharacters {

    public static void main(String[] args) {
        input1();
       // input2();
       // input3();
    }

    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        int n = s.length();
        int maxSize = 0;
        Map<Character, Integer> counter = new HashMap<>();

        int left = 0;
        for (int right = 0; right < n; right++) {
            if(counter.containsKey(s.charAt(right))){
                counter.put(s.charAt(right), counter.get(s.charAt(right)) + 1);
            }else {
                counter.put(s.charAt(right), 1);
            }

            // counter.put(s.charAt(right), counter.getOrDefault(s.charAt(right), 0) + 1);

            while (counter.size() > k) { // invalid sub-string
                counter.put(s.charAt(left), counter.get(s.charAt(left)) - 1);
                if (counter.get(s.charAt(left)) == 0) {
                    counter.remove(s.charAt(left));
                }
                left++;
            }

            maxSize = Math.max(maxSize, right - left + 1);
        }

        return maxSize;
    }

    public static int lengthOfLongestSubstringKDistinct1(String s, int k) {
        if (k == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        int left = 0, right = 0;
        int max = 0, n = s.length();
        int count = 0;
        while (right < n) {
            map.put(chars[right], right);
            if (map.size() > k) {
                int leftMost = Integer.MAX_VALUE;
                for (int id : map.values()) {
                    leftMost = Math.min(leftMost, id);
                }
                map.remove(chars[leftMost]);
                left = leftMost + 1;
            }
            right++;
            max = Math.max(max, right - left);
        }
        return max;
    }

    static void input1(){
        String str = "eceba";
        int k = 2;
        System.out.println("input1 str: " + str);

        System.out.println("input1 lengthOfLongestSubstringKDistinct " + lengthOfLongestSubstringKDistinct(str, k));
        System.out.println("input1 lengthOfLongestSubstringKDistinct1 " + lengthOfLongestSubstringKDistinct1(str, k));
    }

    static void input2(){
        //String str = "eeebbabd";
        String str = "eebda";
        int k = 2;
        System.out.println("input2 input2: " + str);

        System.out.println("input2 lengthOfLongestSubstringKDistinct " + lengthOfLongestSubstringKDistinct(str, k));
        System.out.println("input2 lengthOfLongestSubstringKDistinct1 " + lengthOfLongestSubstringKDistinct1(str, k));
    }

    static void input3(){
       // String str = "abceedeeb";
      //  String str = "eebda";
        String str = "eedeeb";
        int k = 2;
        System.out.println("input3 input2: " + str);

        System.out.println("input3 lengthOfLongestSubstringKDistinct " + lengthOfLongestSubstringKDistinct(str, k));
        System.out.println("input3 lengthOfLongestSubstringKDistinct1 " + lengthOfLongestSubstringKDistinct1(str, k));
    }
}
