package com.leetcode.zothers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

//Given a string s, find the length of the longest substring without repeating characters.

/*
Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringWORepeatingChars {

    public static void main(String[] args) {
       // String str = "abcabcba";
       // String str = "bbbbb";
     //   String str = "pwwkew";
       // String str = "abcaea";
       // String str = "abcabcbb";
        String str = "abcb";
        System.out.println("input " + str);
        System.out.println("lengthOfLongestSubstringSlidingWindow1 " + lengthOfLongestSubstringSlidingWindow1(str));
        System.out.println("lengthOfLongestSubstringUpgradSlidingWindow " + lengthOfLongestSubstringUpgradSlidingWindow(str));
        System.out.println("lengthOfLongestSubstringByHashSet " + lengthOfLongestSubstringByHashSet(str));
       // System.out.println("lengthOfLongestSubstringNotOptimized " + lengthOfLongestSubstringNotOptimized(str));

    }

    //Time : O(2n) == O(n)
    static int lengthOfLongestSubstringUpgradSlidingWindow(String s) {

        int max_len = 0;
        int i =0 , j= 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        while(j< s.length()){

            char ch = s.charAt(j);
            if(hashMap.containsKey(ch)){
                hashMap.put(ch , hashMap.get(ch) + 1);
            }else{
                hashMap.put(ch, 1);
            }

            while(hashMap.get(ch) > 1){
                char ith_char = s.charAt(i);
                hashMap.put(ith_char, hashMap.get(ith_char) -1);
                i++;
                System.out.println("lengthOfLongestSubstringUpgrad hashMap " + hashMap);
            }

            int window_len = j -i +1;
            max_len = Math.max(max_len, window_len);
            j++;
        }
        return max_len;
    }

    static int lengthOfLongestSubstringSlidingWindow1(String s) {
        int max = 0;
        HashMap<Character, Integer> hash = new HashMap<Character, Integer>();
        int i = 0;
        int j = 0;
        while (j < s.length()) {
            if (hash.containsKey(s.charAt(j))) {
                i = Math.max(hash.get(s.charAt(j)), i);
            }
            hash.put(s.charAt(j), j + 1);
            max = Math.max(j - i + 1, max);
            j = j + 1;
        }
        return max;
    }

    static int lengthOfLongestSubstringByHashSet(String s) {
        int max = 0;
        HashSet<Character> hash = new HashSet<Character>();
        int i = 0;
        int j = 0;
        while (i < s.length() && j < s.length()) {
            if (hash.contains(s.charAt(j))) {
                hash.remove(s.charAt(i));
                i = i + 1;
            } else {
                hash.add(s.charAt(j));
                j = j + 1;
                max = Math.max(j - i, max);
            }
            System.out.println();
        }
        return max;
    }


    //Time-O(n*n*n) Space-O(n)
    static int lengthOfLongestSubstringNotOptimized(String s) {
        int max_len =0;
        ArrayList<String> all_substrings = getAllSubstrings(s);
        System.out.println("lengthOfLongestSubstringNotOptimized all_substrings " + all_substrings);

        for(int i=0; i<all_substrings.size(); i++){
            if(!containsDuplicateLetter(all_substrings.get(i))) {
                max_len = Math.max(max_len, all_substrings.get(i).length());
            }
        }
        return max_len;
    }


    static ArrayList getAllSubstrings(String s){
        ArrayList<String> all_substrings = new ArrayList<>();
        for(int i= 0; i<s.length(); i++){
            StringBuilder sub_str = new StringBuilder();
            for(int j=i;j<s.length(); j++){
                sub_str = sub_str.append(s.charAt(j));
                //all_substrings.add(sub_str.toString());
                all_substrings.add(String.valueOf(sub_str));
            }
        }

        return  all_substrings;
    }


    //O(n)
    static boolean containsDuplicateLetter(String str){
        HashSet<Character> hs = new HashSet<Character>();

        for(int i=0; i<str.length(); i++){
            if(hs.contains(str.charAt(i)))
                return true;

            hs.add(str.charAt(i));
        }
        return false;
    }


}
