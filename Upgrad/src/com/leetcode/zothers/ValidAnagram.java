package com.leetcode.zothers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//Given two strings s and t, return true if t is an anagram of s, and false otherwise.
//An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

/*
Example 1:
Input: s = "anagram", t = "nagaram"
Output: true

Example 2:
Input: s = "rat", t = "car"
Output: false

 */
public class ValidAnagram {

    public static void main(String[] args) {
      //input1();
      input2();
    }

    static boolean validAnagramWithTwoMap(String s, String t){

        Map<Character, Integer> hashMap1 = new HashMap<>();
        Map<Character, Integer> hashMap2 = new HashMap<>();

        char[] charArray1 = s.toCharArray();
        char[] charArray2 = t.toCharArray();

        for(int i = 0; i<charArray1.length; i++){
            Character ch = (Character) charArray1[i];
            if(hashMap1.containsKey(ch))
               hashMap1.put(ch,hashMap1.get(ch)+1);
            else
                hashMap1.put(ch,1);
        }

        for(int i = 0; i<charArray2.length; i++){
            Character ch = (Character) charArray2[i];
            if(hashMap2.containsKey(ch))
                hashMap2.put(ch,hashMap2.get(ch)+1);
            else
                hashMap2.put(ch,1);
        }

        System.out.println("validAnagramWithTwoMap hashMap1: " + hashMap1);
        System.out.println("validAnagramWithTwoMap hashMap2: " + hashMap2);
        for(char ch ='a'; ch <='z'; ch++){
            Character cr = (Character)ch;

            if(hashMap1.containsKey(cr) && hashMap2.containsKey(cr)) {
                if (hashMap1.get(cr) != hashMap2.get(cr))
                    return false;
            }else if(!hashMap1.containsKey(cr) && !hashMap2.containsKey(cr))
                continue;
            else
                return  false;
        }
        return true;
    }

    static boolean validAnagramWithOneMap(String s, String t){

        if(s.length()!=t.length())
            return false;

        Map<Character, Integer> hashMap1 = new HashMap<>();
        char[] charArray1 = s.toCharArray();
        char[] charArray2 = t.toCharArray();

        for(char ch='a'; ch <='z'; ch++){
            Character c = (Character) ch;
            hashMap1.put(c,0);
        }

        for(int i = 0; i<charArray1.length; i++){
            Character ch = (Character) charArray1[i];
            hashMap1.put(ch,hashMap1.get(ch)+1);
        }

        for(int i = 0; i<charArray2.length; i++){
            Character ch = (Character) charArray2[i];
            hashMap1.put(ch,hashMap1.get(ch)-1);
        }

        for(char ch ='a'; ch <='z'; ch++){
            Character c = (Character) ch;
            if(hashMap1.get(c)!=0){
                return false;
            }
        }
        return true;
    }

    static boolean validAnagramByArray(String s, String t){
        if(s.length()!=t.length())
            return false;
        int arr[] = new int[26];

//        for(int i=0; i<26; i++){
//            arr[i] =0;
//        }
        for(int i=0; i<s.length(); i++){
            System.out.println("s.charAt(i) -a: " + (s.charAt(i) -'a'));
            arr[s.charAt(i) -'a']++;
        }
        System.out.println("Array " + Arrays.toString(arr));
        for(int i=0; i<t.length(); i++){
            arr[t.charAt(i) -'a']--;
        }
        for(int i=0; i<26; i++){
            if(arr[i] !=0)
                return false;
        }
        return true;
    }

    static boolean validAnagramBySorting(String s, String t){

        char[] charArray1 = s.toCharArray();
        char[] charArray2 = t.toCharArray();

        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        if(Arrays.equals(charArray1,charArray2))
            return true;
        else
            return false;
    }

    static void input1(){
        String s = "abct";
        String t = "cba";
        System.out.println("input1 validAnagramWithTwoMap " + validAnagramWithTwoMap(s, t));
        System.out.println("input1 validAnagramWithOneMap " + validAnagramWithOneMap(s, t));
        System.out.println("input1 validAnagramByArray " + validAnagramByArray(s, t));
        System.out.println("input1 validAnagramBySorting " + validAnagramBySorting(s, t));
    }
    static void input2(){
        String s = "anagram";
        String t = "nagaram";
        System.out.println("input2 validAnagramWithTwoMap " + validAnagramWithTwoMap(s, t));
        System.out.println("input2 validAnagramWithOneMap " + validAnagramWithOneMap(s, t));
        System.out.println("input2 validAnagramByArray " + validAnagramByArray(s, t));
        System.out.println("input2 validAnagramBySorting " + validAnagramBySorting(s, t));
    }
}
